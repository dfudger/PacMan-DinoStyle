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
 * This class is responsible for methods related to collision detection in the pacman game.
 * @author dfudger
 */
public class Collision {
    
    /**
     * This function is passed two coordinates as parameters.
     * If the object represented in the gameMap at the specified coordinates is the same as a wall, return that wall collision is true.
     * @param x
     * @param y
     * @return boolean if wall has been hit
     */
    public static boolean hitWall(int x, int y)
    {
        if(Window.getMapItem(x, y) == 0)
            return true;
        else 
            return false;
    }
    
    /**
     * This function is passed two coordinates as parameters.
     * If the object represented in the gameMap at the specified coordinates is the same as an enemy, return that enemy collision is true.
     * @param x
     * @param y
     * @return boolean if enemy has been hit
     */
    public static boolean hitEnemy(int x, int y)
    {
        if(Window.getMapItem(x, y) == 4)
                return true;
            else 
                return false;    
    }
    
    /**
     * This function is passed two coordinates as parameters.
     * If the object represented in the gameMap at the specified coordinates is the same as the hero, return that hero collision from enemy is true.
     * @param x
     * @param y
     * @return boolean if hero has been hit
     */
    public static boolean hitHero(int x, int y)
    {
        if(Window.getMapItem(x, y) == 5)
                return true;
            else 
                return false;    
    }
}
