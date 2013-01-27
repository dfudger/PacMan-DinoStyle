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
    
    private void changePosition() {}
    
}
