import java.io.*;
import java.util.*;

public class Program {

	public static void main(String[] args) {
		if (args.length != 2)
		{
			System.out.println("Wrong arguments");
			return;
		}
		List<String> file1 = readFile("./src/" + args[0]);
		List<String> file2 = readFile("./src/" + args[1]);
		Set<String> dictionary = new TreeSet<>();
		dictionary.addAll(file1);
		dictionary.addAll(file2);
		Map<String, Integer> map1 =  getWordCount(createEmptyVector(dictionary), file1);
		Map<String, Integer> map2 =  getWordCount(createEmptyVector(dictionary), file2);
		StringBuilder sim = new StringBuilder();
		String similarity = "";
		similarity += getCosLength(map1, map2, dictionary);
		similarity = similarity.substring(0, 4);
		System.out.println("Similarity = " + similarity);
	}

	public static List<String> readFile(String path) {
		List<String> words = new ArrayList<>();
		String str;
		int k = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			while ((str = reader.readLine()) != null) {
				words.addAll(Arrays.asList(str.split(" +")));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		words.remove("");
		return words;
	}

	public static Map<String, Integer> createEmptyVector(Set<String> dictionary) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : dictionary) {
			map.put(word, 0);
		}
		return map;
	}

	public static Map<String, Integer> getWordCount(Map<String, Integer> map, List<String> words) {
		for (String word : words) {
			map.put(word, map.get(word) + 1);
		}
		return map;
	}

	public static double numerator(Map<String, Integer> map1, Map<String, Integer> map2, Set<String> dictionary) {
		double num = 0;

		Iterator<String> iterator = dictionary.iterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			num += map1.get(item) * map2.get(item);
		}
		return num;
	}

	public static double denominator(Map<String, Integer> map) {
		double den = 0;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			den += entry.getValue() * entry.getValue();
		}
		return Math.sqrt(den);
	}

	public static double getCosLength(Map<String, Integer> map1, Map<String, Integer> map2,  Set<String> dictionary) {
		double num;
		double den;
		num = numerator(map1, map2, dictionary);;
		den = denominator(map1) * denominator(map2);
		return num/den;
	}
}
