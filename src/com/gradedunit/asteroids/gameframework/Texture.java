package com.gradedunit.asteroids.gameframework;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Texture {


	/*
	Images used below all come from https://opengameart.org/.
	This is a website thats purpose is to provide open source images that are free to use.
	 */
	private SpriteSheet ps;
	private SpriteSheet as;
	private SpriteSheet ls;
	private BufferedImage playerSheet;
	private BufferedImage asteroidSheet;
	private BufferedImage laserSheet;
	public BufferedImage[] player = new BufferedImage[1]; //stored as an array so I can add new images later if I want
	public BufferedImage[] asteroid = new BufferedImage[1];
	public BufferedImage[] laser = new BufferedImage[1];
	public Texture(){
		BufferedImageLoader loader = new BufferedImageLoader();//object that gets the images to use

		try{
			playerSheet = loader.loadImage("Spaceship2.png"); //spritesheet for the player
			asteroidSheet = loader.loadImage("Asteroid_01.png"); //spritesheet for the asteroid
			laserSheet = loader.loadImage("laser.png"); //spritesheet for the laser
		}catch (Exception e){
			JOptionPane.showMessageDialog(new JPanel(), "Could not open spritesheet", "Error", JOptionPane.ERROR_MESSAGE); //display for the user
			e.printStackTrace();//display for the developer
			System.exit(1);
		}

		//create sprite sheets based on loaded images

		ps = new SpriteSheet(playerSheet);
		as = new SpriteSheet(asteroidSheet);
		ls = new SpriteSheet(laserSheet);
		getTextures();
	}

	private void getTextures(){
		player[0] = ps.grabImage(1, 1, 32, 32); //player image

		asteroid[0] = as.grabImage(2, 1, 128, 128); //asteroid image

		laser[0] = ls.grabImage(1,1, 8, 16);//laser image
	}

}
