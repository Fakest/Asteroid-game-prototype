package com.gradedunit.asteroids.gameframework;

import com.gradedunit.asteroids.gameobjects.GameObject;
import com.gradedunit.asteroids.gameobjects.Laser;
import com.gradedunit.asteroids.gameobjects.ObjectId;
import com.gradedunit.asteroids.gameobjects.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	ObjectController controller;

	public KeyListener(ObjectController controller) {
		this.controller = controller;
	}

	public void keyPressed(KeyEvent e){
		int keyPressed = e.getKeyCode();
		for(int i = 0; i < controller.objects.size(); i++){
			GameObject tempObject = controller.objects.get(i);
			if(tempObject.getId() == ObjectId.Player){
				if(keyPressed == KeyEvent.VK_W){
					tempObject.setSpeed(5);
				}
				if(keyPressed == KeyEvent.VK_S){
					tempObject.setSpeed(0);
				}
				if(keyPressed == KeyEvent.VK_D){
					tempObject.setTheta(tempObject.getTheta() + 0.1);
				}
				if(keyPressed == KeyEvent.VK_A){
					tempObject.setTheta(tempObject.getTheta() - 0.1);
				}
				if(keyPressed == KeyEvent.VK_SPACE){
					controller.addObject(new Laser(tempObject.getX(), tempObject.getY(), ObjectId.Laser, tempObject.getTheta()));
				}
			}
		}
	}

	public void keyReleased(KeyEvent e){
		int keyPressed = e.getKeyCode();
		for(int i = 0; i < controller.objects.size(); i++){
			GameObject tempObject = controller.objects.get(i);
			if(tempObject.getId() == ObjectId.Player){
				if(keyPressed == KeyEvent.VK_S){
					tempObject.setSpeed(0);
				}
			}
		}
	}
}
