package com.gradedunit.asteroids.gameobjects;

import com.gradedunit.asteroids.gameframework.GameController;
import com.gradedunit.asteroids.gameframework.Texture;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Laser extends GameObject {

    public Laser(int x, int y, ObjectId id, double theta) {
        super(x, y, id, theta);
        this.speed = 15;
    }

    @Override
    public void tick() {
		calcMovement();
    }

    @Override
    public void render(Graphics2D g) {
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform old = g2d.getTransform();
		BufferedImage img = tex.laser[0];
		g2d.rotate(theta + Math.PI /2, x + (img.getWidth() / 2), y + (img.getHeight() / 2));
		g2d.drawImage(img, x, y, null);
		g2d.setTransform(old);
    }
}
