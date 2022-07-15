package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;

public class Program {
	public static void main(String[] args) throws IOException {
		if (args.length != 3 || args[1].length() != 1 || args[2].length() != 1) {
			System.err.println("Wrong argument");
			return;
		}
		URI u = URI.create("file:" + args[0]).normalize();
		File f = new File(String.valueOf(Paths.get(u)));
		BufferedImage image = ImageIO.read(f);
		Logic l = new Logic(image, args[1], args[2]);
		l.print();
	}
}
