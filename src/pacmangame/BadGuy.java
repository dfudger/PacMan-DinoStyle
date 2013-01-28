/*
 * 
 * Pacman Game - BadGuy.java
 * CIS*3760 Assignment Two
 * University of Guelph
 * 
 * Author: Danielle Fudger 0621496
 * Contact: dfudger@uoguelph.ca
 * Date: Januray 26, 2013
 * 
 * This is a java based pacman style game. For more information, please see the README. 
 * 
 */
package pacmangame;

import java.util.Random;

/**
 *
 * @author dfudger
 */
public class BadGuy extends Character 
{
    public BadGuy(int x, int y) 
    {
        super();
        setImage("images/badGuy.jpg");
        setLocation(x, y);
    }
    
    private int randDirection()
    {
        Random r = new Random();
        int n = r.nextInt(4-0);
        
        return n;
    }
    
    public void changeDirection() 
    {
        int x= 0, y= 0, d= 0, posX, posY;
        boolean wall = true;
        
        //Get current position on the board
        posX = this.getHLocation();
        posY = this.getVLocation();
        //System.out.println("Current position: " + posX + " " + posY);
        
        while(wall)
        {
            d = randDirection();
        
            if(d == 0) //North
            {
                //System.out.println("North!");
                x = 0;
                y = -1;
                wall = Collision.hitWall(posX+x, posY+y);
            }

            if(d == 1) //East
            {
                //System.out.println("East!");
                x = 1;
                y = 0;
                wall = Collision.hitWall(posX+x, posY+y);
            }

            if(d == 2) //South
            {
                //System.out.println("South!");
                x = 0;
                y = 1;
                wall = Collision.hitWall(posX+x, posY+y);
            }

            if(d == 3) //West
            {
                //System.out.println("West!");
                x = -1;
                y = 0;
                wall = Collision.hitWall(posX+x, posY+y);
            }
        }

        //If the position rock on has energy, then set the number to 1
        if(Window.getEnergy(posX, posY) == 1)
            Window.setMapPosition(posX, posY, 2);
        else
            Window.setMapPosition(posX, posY, 3);
        
        
        Window.setMapPosition((posX+x), (posY+y), 4);
        this.setLocation((posX+x), (posY+y));
          
    }  
}
