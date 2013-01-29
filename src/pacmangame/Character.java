/*
 * 
 * Pacman Game - Character.java
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
 * This class creates a character object that will be either a hero or bad guy (subclasses)
 * These characters will make up part of the game and the user will interact with them to complete the goal of the game. 
 * @author dfudger
 */
public class Character 
{
    public static String actorImage = "";
    public int actorHposition = 1;
    public int actorVposition = 1;
    
    /**
     * The constructor is empty because these elements will be set within the subclasses.
     */
    public Character() {} //None, will pull from subclasses

    /**
     * This function takes a string and sets it as the actorImage variable for the object.
     * This image will be used for the game.
     * @param s
     */
    public void setImage(String s) 
    {
        this.actorImage = s;
    }
    
    /**
     * The function takes the string actorImage that is associated with the object and returns the string to the calling function.
     * @return string of image url
     */
    public String getImage() 
    {
        return Character.actorImage;
    }
    
    /**
     * The function takes the x coordinate that is associated with the object and returns that integer to the calling function.
     * @return x coordinate
     */
    public int getHLocation() 
    {
        return this.actorHposition;
    }
    
    /**
     * The function takes the y coordinate that is associated with the object and returns that integer to the calling function.
     * @return y coordinate
     */
    public int getVLocation() 
    {
        return this.actorVposition;
    }
    
    /**
     * This function takes two integers passed as parameters and sets them as the x and y coordinates for the object.
     * These coordinates will help track that objects location within the game.
     * @param x
     * @param y
     */
    public void setLocation(int x, int y) 
    {
        this.actorHposition = x;
        this.actorVposition = y;
    } 
}
