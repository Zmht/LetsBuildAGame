package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{

	private Handler handler;

	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;

		velX = 5;
		velY = 5;
	}

	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY; 
		
		if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;

		handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}
	

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 16, 16);
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, 16, 16);
	}
}
