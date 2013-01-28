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
    public BadGuy() 
    {
        super();
        setImage("images/badGuy.jpg");
        setLocation(2, 2);
    }
    
    private int randDirection()
    {
        Random r = new Random();
        int n = r.nextInt(4-0);
        
        return n;
    }
    
    public void chooseDirection() 
    {
       
        
        
       //System.out.println("ping");
       /* int posH, posV, d;
        int x = 0, y= 0;
        boolean wall = false, hero = false;
        
        posH = this.getHLocation();
        posV = this.getVLocation();
        
        System.out.println("Coordinates: " + posH + posV);
        
        //Pick a random direction. 
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
        
        System.out.println("x & Y: " + x + y);
        System.out.println("Combines: " + (posH+x) + (posV+y));
        
        //Check if moving will force you to hit a wall.
        wall = Collision.hitWall(posH+x, posV+y);
        System.out.println("Wall: " + wall);
        while(wall == true)
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
            
            wall = Collision.hitWall(posH+x, posV+y);
            System.out.println("x & Y: " + x + y);
            System.out.println("Combines: " + (posH+x) + (posV+y));
            System.out.println("Wall: " + wall);
        
        */
        }
        
        if(wall == false && hero == false)
        {
            this.setLocation(posH+x, posV+y);
            
            if(Window.getEnergy(posH, posV) == 1)
            {
                System.out.println("Energy!");
                //Window.setMapPosition(posH, posV, 2);
            }
            else
            {
                System.out.println("No Energy");
                //Window.setMapPosition(posH, posV, 3);
            }
            Window.setMapPosition(posH, posV, 3);
            //if(h > 0)
              //  setImage(Window.hero);
            //else
              //  setImage(Window.hero);
            
            this.setLocation(posH+x, posV+y);
            Window.setMapPosition(posH + x, posV + y, 4);   
            
            posH = this.getHLocation();
            posV = this.getVLocation();
            System.out.println("New Spot:\t map[" + posH + "][" + posV + "]\n");
            
        }
        
        
        //Check if moving will force you to hit a wall.
        //wall = Collision.hitWall(posH+h, posV+v);
        //enemy = Collision.hitWall(posH+h, posV+v);
        
        //System.out.println("Original:\t map[" + posH + "][" + posV + "]\n");
        //System.out.println("Original:\t newPosition[" + v + "][" + v + "]\n");
        //if (wall == true)
        //{
        //    return;
        //}
        
        //if(wall == false && enemy == false)
        //{
        //    setLocation(posH+h, posV+v);
        //    Window.setMapPosition(posH + h, posV + v, 5);
        //    Window.setMapPosition(posH, posV, 3);
        //}
            
        //setLocation(posH+h, posV+v);        
        //Window.setMapPosition(posH + h, posV + v, 5);
        
        //Window.gameMap[posH + h][posV + v] = 5;
        //Window.gameMap[posH][posV] = 3;
        //System.out.println("Position Changed!\n");
        
        //posH = getHLocation();
        //posV = getVLocation();
        //System.out.println("New Spot:\t map[" + posH + "][" + posV + "]\n");
        
    }
    
}
