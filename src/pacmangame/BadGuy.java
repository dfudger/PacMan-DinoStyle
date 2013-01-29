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
 * BasGuy is a subclass that creates a character with features of a BadGuy.
 * The BadGuy randomly moves around the game board. Its goal is to block and kill the hero.
 * @author dfudger
 */
public class BadGuy extends Character 
{
    /**
     * The constructor creates a BadGuy and places him at specific coordinates provided as parameters for this constructor.
     * @param x
     * @param y
     */
    public BadGuy(int x, int y) 
    {
        super();
        setImage("images/badGuy.jpg");
        setLocation(x, y);
    }
    
    /*
     * Function chooses a random number between 0 - 3 and returns that number to the callign function.
     */
    private int randDirection()
    {
        Random r = new Random();
        int n = r.nextInt(4-0);
        
        return n;
    }
    
    /**
     * This is responsible for changing the direction of a BadGuy on the game board. 
     * It randomly chooses a position that will not place the BadGuy in a wall and then moves their location to the new position.
     * If that new position hits the hero, then the game is lost for the player.
     * It then checks to see if it's current position is above energy, if so, it will display that energy when it moves to its new position.
     */
    public void changeDirection() 
    {
        int x= 0, y= 0, d= 0, posX, posY;
        boolean wall = true;
        
        //Get current position on the board
        posX = this.getHLocation();
        posY = this.getVLocation();
        
        while(wall) //Are you going to hit a wall?
        {
            d = randDirection();
        
            if(d == 0) //North
            {
                x = 0;
                y = -1;
            }

            if(d == 1) //East
            {
                x = 1;
                y = 0;
            }

            if(d == 2) //South
            {
                x = 0;
                y = 1;
            }

            if(d == 3) //West
            {
                x = -1;
                y = 0;
            }
            
            wall = Collision.hitWall(posX+x, posY+y);
        }

        if(Collision.hitHero(posX+x, posY+y)) //Are you going to hit the hero?
            Window.gameLost();
        
        
        //If the position BadGuy is on has energy, then set the number to 1
        if(Window.getEnergy(posX, posY) == 1)
            Window.setMapPosition(posX, posY, 2);
        else
            Window.setMapPosition(posX, posY, 3);
        
        
        Window.setMapPosition((posX+x), (posY+y), 4);
        this.setLocation((posX+x), (posY+y));
    }  
}
