package com.gradedunit.asteroids.gameobjects;

import com.gradedunit.asteroids.gameframework.GameController;
import com.gradedunit.asteroids.gameframework.Texture;

import java.awt.*;
import java.util.LinkedList;

//Super class for game gameobjects such as player, asteroid, bullet, etc

public abstract class GameObject {
    protected int x, y; //coordinates
    protected ObjectId id; //id used to identify what type of objects each class is
    protected double theta; //theta is the radian angle used to rotate the
    protected int speed; //speed is the value that is used with theta to work out the change in x and y required
	protected Texture tex = GameController.getInstance(); //get textures from main class

    public GameObject(int x, int y, ObjectId id, double theta){
        this.x = x;
        this.y = y;
        this.id = id;
		this.theta = theta;
    }

	public GameObject(ObjectId id) { //used to generate the asteroids
		this.id = id;
	}

	public abstract void tick();

	public abstract void render(Graphics2D g);

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public double getTheta() {
		return theta;
	}
	public void setTheta(double theta) {
		this.theta = theta;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ObjectId getId() {
		return id;
	}

	public void calcMovement(){
		this.x += (int)Math.round(this.speed * Math.cos(this.theta));
		this.y += (int)Math.round(this.speed * Math.sin(this.theta));
	}

	@Override
	public String toString() {
		return "GameObject{" +
				"x=" + x +
				", y=" + y +
				", id=" + id +
				", theta=" + theta +
				", speed=" + speed +
				'}';
	}
}
