/*
 * 
 * Pacman Game - Map.java
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
public class Map 
{
    public String [][] layout = new String[20][20];
    public static String wall = "images/wall.jpg";
    public static String floorFull = "images/floorFull.jpg";
    public static String floorEmpty = "images/floorEmpty.jpg";
    public static String hero = "images/hero.jpg";
    public static String badGuy = "images/badGuy.jpg";
    
    public Map() 
    {
        /*for(int i = 0; i < 20; i++)
        {
            for(int j = 0; i < 20; j++)
            {
                layout[i][j] = floorFull;
            }
        }*/
    }
    
    private void getImage() {}
    
    private void setImage() {}
    
    private void countEnergy() {}
    
    private void updateScreen() {}
}
