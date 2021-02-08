package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{

    private Handler handler;
    private Random r = new Random();

    private int red = r.nextInt(255);
    private int green= r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color randColor;

	public MenuParticle(float x, float y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;
        
		velX = 2;
        velY = 9;
        
        randColor= new Color(red, green, blue);

	}

	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;

		handler.addObject(new Trail((int) x, (int) y, ID.Trail, randColor, 16, 16, 0.02f, handler));
	}
	

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(randColor);
		g.fillRect((int) x, (int) y, 16, 16);
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, 16, 16);
	}
}
