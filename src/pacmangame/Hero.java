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
 * This class is a subclass of character. Hero class creates and handled the hero object (the dino) for the pacman game.
 * The hero collects energy and moves around the board trying not to get hit by a meteor. 
 * @author dfudger
 */
public class Hero extends Character 
{
    /**
     * Created the hero object based on the character object. 
     * The hero begins at the top left of the map and has a predetermined image.
     */
    public Hero() 
    {
        super();
        setImage("images/heroR.jpg");
        setLocation(2, 2);
    }
    
    /**
     * This function moves the hero around the game board, collects energy, and checks collision. 
     * It is passed coordinates that indicate how far to move the heros position on the game board.
     * 
     * If the position is on a wall then the player is not allowed to move that direction. If they hit an enemy, the game is over.
     * @param x
     * @param y
     */
    public void changePosition(int x, int y) 
    {
        int posX, posY, energy;
        boolean wall, enemy;
        
        posX = this.getHLocation();
        posY = this.getVLocation();
        
        //Check if moving will force you to hit a wall.
        wall = Collision.hitWall(posX+x, posY+y);
        enemy = Collision.hitWall(posX+x, posY+y);
        
        if(wall == true)
            return;
        
        if(Collision.hitEnemy(posX+x, posY+y))
            Window.gameLost();
        
        if(wall == false) //No collision problems
        {   
            if(Window.getEnergy(posX+x, posY+y) == 1) //Change energy status if energy there
                Window.setEnergy(posX+x, posY+y, 0);
            
            if(y < 0) //Change dinos image if it changes direction
                this.setImage(Window.heroL);
            else
                this.setImage(Window.heroR);
            
            setLocation(posX+x, posY+y); //for hero object
            
            Window.setMapPosition(posX+x, posY+y, 5); //Update heros image on map to new location
            Window.setMapPosition(posX, posY, 3); //Make old position an empty floor spot
        }
    }  
}
