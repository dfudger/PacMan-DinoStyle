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
 *
 * @author dfudger
 */
public class Character 
{
    public String actorImage = "";
    public int actorHposition = 1;
    public int actorVposition = 1;
    
    public Character() {} //None, will pull from subclasses

    public void setImage(String s) 
    {
        this.actorImage = s;
    }
    
    public int getHLocation() 
    {
        return this.actorHposition;
    }
    
    public int getVLocation() 
    {
        return this.actorVposition;
    }
    
    public void setLocation(int h, int v) 
    {
        this.actorHposition = h;
        this.actorVposition = v;
    }
    
    private void die() {}
    
    
}
