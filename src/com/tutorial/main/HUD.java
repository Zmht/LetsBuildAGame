package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	

	public static float HEALTH = 100f;
	private float greenValue = 255f;

	private int score = 0;
	private int level = 1;

	public void tick() {
		//HEALTH--;
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);

		greenValue = HEALTH * 2;

		score++;
		//if(HEALTH == 0){
		//	System.exit(1);
		//}
	}
	
	public void render(Graphics g) {
		 g.setColor(Color.gray);
		 g.fillRect(15, 15, 200, 32);
		 g.setColor(new Color(75, (int) greenValue, 0));
		 g.fillRect(15, 15, (int) HEALTH * 2, 32);
		 g.setColor(Color.white);
		 g.drawRect(15, 15, 200, 32);

		 g.drawString("Score: " + score, 15, 64);
		 g.drawString("Level: " + level, 15, 80);
	}

	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return score;
	}

	public void setLevel(int level){
		this.level = level;
	}

	public int getLevel(){
		return level;
	}

}
