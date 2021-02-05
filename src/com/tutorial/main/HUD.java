package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int health = 100;
	

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		 g.setColor(Color.GRAY);
		 g.fillRect(15, 15, 200, 32);
		 g.setColor(Color.GREEN);
		 g.fillRect(15, 15, health * 2, 32);
	}
}
