package com.gradedunit.asteroids.gameframework;

import com.gradedunit.asteroids.gameobjects.Asteroid;
import com.gradedunit.asteroids.gameobjects.GameObject;
import com.gradedunit.asteroids.gameobjects.ObjectId;

import java.awt.*;
import java.util.LinkedList;

public class ObjectController {

	/*
	linked list below to store all game GameObjects
	GameObjects use ids to be identified later so we can store them all in one list.
	*/
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();

	public void tick(){
	    int count = 0; //counter used to calculate how many asteroids are on the screen
		for(int i = 0; i < objects.size(); i++){
			GameObject tempObject = objects.get(i);
			tempObject.tick(); //update object
			if(tempObject.getId() == ObjectId.Asteroid){
				count ++;
			}
			if(tempObject.getId() == ObjectId.Laser){
				if(tempObject.getX() < -10 || tempObject.getX() > GameController.getWIDTH() + 10 || tempObject.getY() < -10 || tempObject.getY() > GameController.getHEIGHT() + 10){
					removeObject(tempObject);
				}
			}
		}

		while(count<5){
			addObject(new Asteroid(ObjectId.Asteroid));
			count++;
		}

	}

	public void render(Graphics2D g){
		for(int i = 0; i < objects.size(); i++){
			GameObject tempObject = objects.get(i);

			tempObject.render(g); //draw object
		}
	}

	public void addObject(GameObject object){ //add object to list
		this.objects.add(object);
	}

	public void removeObject(GameObject object){ //remove object to list
		this.objects.remove(object);
	}

	@Override
	public String toString() {
		return "ObjectController{" +
				"objects=" + objects +
				'}';
	}
}
