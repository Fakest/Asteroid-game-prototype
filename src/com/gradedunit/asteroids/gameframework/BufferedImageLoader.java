package com.gradedunit.asteroids.gameframework;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedImageLoader {
	private BufferedImage image;

	public BufferedImage loadImage(String path){
		try {
			image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
