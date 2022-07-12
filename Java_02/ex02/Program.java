import java.io.IOException;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
	public static void main(String[] args) throws IOException{
		String path = "";
		if (args.length == 1) {
//			path = args[0];
//			System.out.println("path " + path);
			if (args[0].startsWith("--current-folder=C:")) {
//				System.out.println("path " + path);
				path = "file:" + args[0].substring(19);
				System.out.println(path);
			} else {
				System.out.println("Wrong argument");
				return;
			}
		}
		if (Paths.get((URI.create(path).normalize())).isAbsolute() == false) {
			System.out.println("Wrong argument");
			return;
		}
		File file = new File(path);
		if (file.exists() == false || file.isDirectory() == false) {
			System.out.println("Wrong argument");
			return;
		}

		Scanner sc = new Scanner(System.in);
		String str;
		while (sc.hasNext()) {
			str = sc.nextLine();
		}

//		Files.list(Paths.get(URI.create(path).normalize())).forEach(file -> {
//			System.out.println(file.getFileName());
//		});
//
////		String pathFrom = "file:///Users/hdale/Desktop/JAVA_Piscine/Java_02/ex02/src/text.txt";
////		String pathTo = "file:///Users/hdale/Desktop/JAVA_Piscine/Java_02/ex02/src/test/text.txt";
////		Files.move(Paths.get(URI.create(pathFrom)), Paths.get(URI.create(pathTo)));
//
//
//		String folder = ".";
//		String newFolder = path +"/" + folder;
//		Path newPath = Paths.get(URI.create(newFolder));
//
//		if (Files.exists(newPath) && Files.isDirectory(newPath)) {
//			path = newPath.normalize().toString();
//			System.out.println(path);
//		}
//
//		System.out.println("size=" + getSize(Paths.get(URI.create("file:///Users/hdale/Desktop/JAVA_Piscine/Java_02/ex02/src/test/3"))));
//		System.out.println(Files.size(Paths.get(URI.create("file:///Users/hdale/Desktop/JAVA_Piscine/Java_02/ex02/src/test/3"))));
//
////		Iterator<Path> iterator = Paths.get(URI.create(path)).iterator();
////		while (iterator.hasNext()) {
////			System.out.println(iterator.next().getFileName());
////		}






	}

	public static long getSize(Path path) throws IOException {
		if (Files.isDirectory(path)) {
			List<Path> collect = Files.list(path).collect(Collectors.toList());
			long size = 0;
			for (Path p : collect) {
				size += getSize(p);
			}
			return size + Files.size(path);
		} else {
			return Files.size(path);
		}
	}

}
