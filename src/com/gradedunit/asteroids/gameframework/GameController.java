package com.gradedunit.asteroids.gameframework;

import com.gradedunit.asteroids.gameobjects.Asteroid;
import com.gradedunit.asteroids.gameobjects.ObjectId;
import com.gradedunit.asteroids.gameobjects.Player;
import com.gradedunit.asteroids.window.Screen;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Arrays;

public class GameController extends Canvas implements Runnable {

	//variables used to run game
	private boolean running = false;
	private Thread thread;
	private static final int WIDTH = 800, HEIGHT = 600;

	//objects used for game
	private ObjectController objectHandler;

	private static Texture tex;

	public static void main(String args[]) {
		new Screen(WIDTH, HEIGHT, "Asteroids", new GameController());
	}

	public synchronized void start() {

		if (running) { //if the thread has already started then don't bother with this
			return;
		}

		running = true;
		thread = new Thread(this, "GameController Thread"); //creating the main thread that will run the game
		thread.start();

	}

	@Override
	public void run() {
		initialiseGame();
		this.requestFocus();
		loopGame();


	}

	private void loopGame() {
		/*
		source for code
		https://www.youtube.com/watch?v=Zh7YiiEuJFw&index=2&list=PLWms45O3n--54U-22GDqKMRGlXROOZtMx
		calculates the frames generated per second
		calculates how many updates have been done (ticks) per second
		the program will try to do 30 updates per second.
		 */
		System.out.println(getName() + " Thread has begun");
		long lastTime = System.nanoTime();
		double amountOfTicks = 30.0; //how many frames are allowed to be displayed per second
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0; //how many updates there have been per second
		int frames = 0; //how many frames have been generated per second
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns; //delta how long the program has been running
			lastTime = now;
			while (delta >= 1) {
				tick();//update everything
				updates++; //how many ticks there have been
				delta--;
			}
			render();//render everything
			frames++; //each time this happens add one to the frames counter

			if (System.currentTimeMillis() - timer > 1000) { //every second print
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				System.out.println(objectHandler);
				frames = 0; //resets the frame counter so next update will tell me how many frames have been generated in the next run
				updates = 0; //resets the updates counter so next update will tell me how many frames have been generated in the next run
			}

		}
	}

	private void tick() {
		objectHandler.tick();//every object in the object controller will be ticked (updated)

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy(); //buffer strategy is used to render images before they are displayed
		if(bs == null){
			this.createBufferStrategy(3); //loads the images needed before they are actually required, improving efficiency
			return;
		}
		Graphics2D g = (Graphics2D)bs.getDrawGraphics(); //get graphics context for buffering

		//draw area start
		//colour background black
		g.setColor(Color.BLACK);
		g.fillRect(0,0, getWidth(), getHeight());

		//render all objects in the handler
		objectHandler.render(g);

		//draw area ending
		g.dispose();
		bs.show();
	}

	private void initialiseGame(){ //initialize game
		objectHandler = new ObjectController(); //new controller for the objects called object handler
		tex = new Texture(); //where all the textures are stored
		objectHandler.addObject(new Player(WIDTH/2, HEIGHT/2, ObjectId.Player, (3 * Math.PI) / 2)); //3*pi /2 makes the player initially point upward
		objectHandler.addObject(new Asteroid(ObjectId.Asteroid)); //adds a new asteroid
		this.addKeyListener(new KeyListener(objectHandler));
	}

	public static int getWIDTH() {
		return WIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static Texture getInstance(){
		return tex;
	}

}
