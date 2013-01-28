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
        setImage("/images/heroLeft.jpg");
        setLocation(1, 1);
    }
    
    public void changePosition(int h, int v) 
    {
        int posH, posV;
        boolean wall, enemy;
        
        posH = getHLocation();
        posV = getVLocation();
        
        //Check if moving will force you to hit a wall.
        wall = Collision.hitWall(posH+h, posV+v);
        enemy = Collision.hitWall(posH+h, posV+v);
        
        //System.out.println("Original:\t map[" + posH + "][" + posV + "]\n");
        //System.out.println("Original:\t newPosition[" + v + "][" + v + "]\n");
        if (wall == true)
        {
            return;
        }
        
        if(wall == false && enemy == false)
        {
            setLocation(posH+h, posV+v);
            Window.gameMap[posH + h][posV + v] = 5;
            Window.gameMap[posH][posV] = 3;
        }
            
        setLocation(posH+h, posV+v);
        
        Window.gameMap[posH + h][posV + v] = 5;
        Window.gameMap[posH][posV] = 3;
        System.out.println("Position Changed!\n");
        
        //posH = getHLocation();
        //posV = getVLocation();
        //System.out.println("New Spot:\t map[" + posH + "][" + posV + "]\n");
        
    }
    
}
