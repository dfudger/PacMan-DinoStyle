/*
 * 
 * Pacman Game - Hero.java
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

/**
 *
 * @author dfudger
 */
public class Hero extends Character 
{
    public Hero() 
    {
        super();
        setImage("images/hero.jpg");
        setLocation(2, 2);
    }
    
    public void changePosition(int h, int v) 
    {
        int posH, posV, energy;
        boolean wall, enemy;
        
        posH = this.getHLocation();
        posV = this.getVLocation();
        
        //Check if moving will force you to hit a wall.
        wall = Collision.hitWall(posH+h, posV+v);
        enemy = Collision.hitWall(posH+h, posV+v);
        
        if(wall == true)
        {
            return;
        }
        
        if(wall == false && enemy == false)
        {
            
            if(Window.getEnergy(posH+h, posV+v) == 1)
                Window.setEnergy(posH+h, posV + v, 0);
            
            if(h > 0)
                this.setImage(Window.hero);
            else
                this.setImage(Window.hero);
            
            setLocation(posH+h, posV+v);
            
            Window.setMapPosition(posH + h, posV + v, 5);
            Window.setMapPosition(posH, posV, 3);
        }
            
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
