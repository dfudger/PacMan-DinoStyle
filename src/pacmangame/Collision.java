/*
 * 
 * Pacman Game - Collision.java
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
public class Collision {
    
    public static boolean hitWall(int x, int y)
    {
        if(Window.gameMap[x][y] == 0)
            return true;
        else 
            return false;
    }
    
    public static boolean hitEnemy(int x, int y)
    {
        if(Window.gameMap[x][y] == 4)
                return true;
            else 
                return false;    
    }
    
    public static boolean hitHero(int x, int y)
    {
        if(Window.gameMap[x][y] == 5)
                return true;
            else 
                return false;    
    }
}
