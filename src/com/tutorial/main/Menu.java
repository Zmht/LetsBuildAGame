package com.tutorial.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import com.tutorial.main.Game.STATE;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Menu extends MouseAdapter{

    private Game game;
    private Handler handler;
    private Random r = new Random();


    public Menu(Game game, Handler handler){
         this.game = game;
         this.handler = handler;
    }
  
    
    
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(game.gameState == STATE.Menu){

        //Play Button
        if(mouseOver(mx, my, 220, 150, 200, 64)){
            game.gameState = STATE.Game;
            handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
        }

        //Help button
        if(mouseOver(mx, my, 220, 250, 200, 64)){
            game.gameState = STATE.Help;
        }

        //Quit button
           if(mouseOver(mx, my, 220, 350, 200, 64)){
           System.exit(1);
           }
        }

        

        //HelpBackButton
        if(game.gameState == STATE.Help){
            if(mouseOver(mx, my, 220, 350, 200, 64)){
                game.gameState = STATE.Menu;
                return;
            }
        }       
    }

        

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }else return false;
        }else return false;
    }

    public void mouseReleased(MouseEvent e){

    }

    public void render(Graphics g){

        if(game.gameState == STATE.Menu){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
           
            g.setFont(fnt);
            g.setColor(Color.blue);
            g.drawString("D", 240, 70);
            g.setColor(Color.red);
            g.drawString("O", 275, 70);
            g.setColor(Color.yellow);
            g.drawString("D", 315, 70);
            g.setColor(Color.blue);
            g.drawString("G", 355, 70);
            g.setColor(Color.green);
            g.drawString("E", 395, 70);
            /*g.setColor(Color.magenta);
            g.drawString("e", 240, 70);*/
            

    
            g.setFont(fnt2);
            g.setColor(Color.white);
            
            g.drawRect(220, 150, 200, 64);
            g.drawString("Play", 270, 190);
    
            g.drawRect(220, 250, 200, 64);
            g.drawString("Help", 270, 290);
    
            g.drawRect(220, 350, 200, 64);
            g.drawString("Quit", 270, 390);
        }else if(game.gameState == STATE.Help){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 16);
            Font fnt3 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);

            g.setFont(fnt2);

            g.drawString("This is a cool little game I made", 150, 150);
            g.drawString("following a tutorial on youtube.", 150, 170);
            g.drawString("WASD keys for movement, esc for exit", 150, 190);

            g.setFont(fnt3);
            g.drawRect(220, 350, 200, 64);
            g.drawString("Back", 270, 390);

        }
    }
    public void tick(){

    }
}
