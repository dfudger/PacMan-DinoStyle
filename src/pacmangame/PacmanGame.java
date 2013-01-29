/*
 * 
 * Pacman Game - PacmanGame.java
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
 * This class creates and runs the pacman man game.
 * @author dfudger
 */
public class PacmanGame 
{
    /**
     * The main function is responsible for beginning the pacman game. It creates the GUI that will create all of the necessary objects and runs the program
     * until the user wins, loses, or quits.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Window gui = new Window();
        gui.setVisible(true);
    }
}
