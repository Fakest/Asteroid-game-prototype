package com.gradedunit.asteroids.gameobjects;

import com.gradedunit.asteroids.gameframework.GameController;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
	private int score = 0;
	public Player(int x, int y, ObjectId id, double theta) {
		super(x, y, id, theta);
	}

	@Override
	public void tick() {
		calcMovement(); // carry out trig calculations required to move

		x = contain(x, 0, GameController.getWIDTH() - 16); //ensures the player sprite does not go off the screen
		y = contain(y, 0, GameController.getHEIGHT() -32);

	}

	public void render(Graphics2D g){

		AffineTransform old = g.getTransform(); //remember the old rotation
		BufferedImage img = tex.player[0]; // get the image required
		g.rotate(theta + Math.PI /2, x + (img.getWidth() / 2), y + (img.getHeight() / 2)); // theta + math.pi/2 is to orientate the sprite in the right direction
		g.drawImage(img, x, y, null); //draws the image in the correct orientation
		g.setTransform(old); //resets the graphics object back to the original orientation so other objects will be displayed properly
	}

	public int contain(int val, int min, int max){
		//if value passed is more than the max limit then
		if(val >= max){
			return max; //return the max limit rather than the val
		}else if(val <=min){ // of val is less than the minimum limit  then
			return min;//return the minimum accepted value instead
		}else{
			return val;// if neither are true then just return the value
		}
	}

}

