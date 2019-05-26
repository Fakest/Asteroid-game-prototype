package com.gradedunit.asteroids.gameframework;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage image;
	public SpriteSheet(BufferedImage image){
		this.image = image;
	}

	public BufferedImage grabImage(int col, int row, int width, int height){
		BufferedImage img = image.getSubimage((col * width) - width, (row * height) - height, width, height); //if i want column 3, to find it i need to multiply by the size of the image to get the required
		return img; //return the image found at the location specified in the parameters
	}
}
