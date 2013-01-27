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
        
        posH = getHLocation();
        posV = getVLocation();
        
        System.out.println("Original:\t map[" + posH + "][" + posV + "]\n");
        System.out.println("Original:\t newPosition[" + v + "][" + v + "]\n");
        
        setLocation(posH+h, posV+v);
        
        Window.gameMap[posH + h][posV + v] = 5;
        Window.gameMap[posH][posV] = 3;
        System.out.println("Position Changed!\n");
        
        posH = getHLocation();
        posV = getVLocation();
        
        int foo;
        
        System.out.println("New Spot:\t map[" + posH + "][" + posV + "]\n");
    }
    
}
