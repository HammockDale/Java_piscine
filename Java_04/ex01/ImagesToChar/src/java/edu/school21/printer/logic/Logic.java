package edu.school21.printer.logic;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Logic {
	private String black;
	private String wite;
	private BufferedImage image;

	public Logic(BufferedImage image, String b, String w) {
		this.image = image;
		this.black = b;
		this.wite = w;
	}

	public void print() {
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				Color color = new Color(image.getRGB(j, i));
				if ( color.getRGB() == Color.BLACK.getRGB()) {
					System.out.print(black);
				}
				else {
					System.out.print(wite);
				}
			}
			System.out.println();
		}
	}


}
