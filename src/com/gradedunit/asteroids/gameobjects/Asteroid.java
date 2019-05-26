package com.gradedunit.asteroids.gameobjects;

import com.gradedunit.asteroids.gameframework.GameController;
import com.gradedunit.asteroids.gameframework.Texture;
import com.gradedunit.asteroids.window.Screen;

import java.awt.*;
import java.util.Random;

public class Asteroid extends GameObject{

	public Asteroid(ObjectId id) {
		super(id);
		generateAsteroid();//used to initialize the data with random values
	}

	@Override
	public void tick() {
		calcMovement();//this function is created in the GameObject super class, uses the angle of the object and speed to work out how far to move it along the x and y axis

		if(x < -250 || y < -250 || x > GameController.getWIDTH()+250| y > GameController.getHEIGHT()+250){
			generateAsteroid();
			}
		}


	private void generateAsteroid(){
		/*
		this function is used to choose a random position for the asteroid to spawn while assigning values that are appropriate
		the function is called when the asteroid is created and when the asteroid moves out of bounds.
		*/
		Random r = new Random();
		int pos = r.nextInt(4) + 1; //position 1 is at the top of the screen, position 2 is the right side of the screen, position 3 is the bottom of the screen and position 4 is at the left

		switch(pos) {//switch used to assign correct and appropriate values to the asteroid
			case 1:
				this.x = r.nextInt(GameController.getWIDTH()); // a value between 0 and the width of the screen
				this.y = (r.nextInt(250) + 128) * -1; //a value between 250 and 128 pixels above the screen
				this.theta = Math.toRadians(r.nextInt(135) + 45); //rotation of the asteroid is random so they are different
				this.speed = r.nextInt(8) + 4; //random speed between 8 and 4 pixels a second
				break;
			case 2:
				this.x = r.nextInt(250) + GameController.getWIDTH() + 128;
				this.y = (r.nextInt(GameController.getHEIGHT()));
				this.theta = Math.toRadians(r.nextInt(315) + 405);
				this.speed = r.nextInt(8) + 4;
				break;
			case 3:
				this.x = r.nextInt(GameController.getWIDTH());
				this.y = r.nextInt(250) + GameController.getHEIGHT() + 128;
				this.theta = Math.toRadians(r.nextInt(315) + 225);
				this.speed = r.nextInt(8) + 4;
				break;
			case 4:
				this.x = (r.nextInt(250) + 128) * -1;
				this.y = (r.nextInt(GameController.getHEIGHT()));
				this.theta = Math.toRadians(r.nextInt(225) + 105);
				this.speed = r.nextInt(8) + 4;
				break;
		}
	}


	@Override
	public void render(Graphics2D g) {
		g.drawImage(tex.asteroid[0], x, y, null); //draw graphic saved in the texture class
	}

}
