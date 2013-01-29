/*
 * 
 * Pacman Game - Window.java
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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.swing.*;


/**
 *
 * @author dfudger
 */
public class Window extends JFrame implements KeyListener
{
    /***Objects***/
    public Hero dino;
    public BadGuy meteor;
    public Vector v;
    
    public Container content;
    public static JFrame box, win;
    public static JFrame lose; 
    
    /***Image Strings***/
    public static String wall = "/wall.jpg";
    public static String floorFull = "/floorFull.jpg";
    public static String floorEmpty = "/floorEmpty.jpg";
    public static String heroR = "/heroR.jpg";
    public static String heroL = "/heroL.jpg";
    public static String badGuy = "/badGuy.jpg";
    
    public static final int width = 31;
    public static final int height = 29;
    
    
    
    /***Map Arrays***/
    public static int[][] gameMap = 
    {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,5,2,2,2,2,2,2,2,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,2,0,0,0,2,2,0,0,0,0,2,2,0,2,2,0,0,0,0,2,2,0,0,0,2,2,0},
        {0,2,2,0,0,0,2,2,0,0,0,0,2,2,0,2,2,0,0,0,0,2,2,0,0,0,2,2,0},
        {0,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,2,0,0,0,2,2,0,2,2,0,0,0,0,0,0,0,2,2,0,2,2,0,0,0,2,2,0},
        {0,2,2,2,2,2,2,2,0,2,2,2,2,2,0,2,2,2,2,2,0,2,2,2,2,2,2,2,0},
        {0,2,2,2,2,2,2,2,0,2,2,2,2,2,0,2,2,2,2,2,0,2,2,2,2,2,2,2,0},
                    
        {0,0,0,0,0,0,2,2,0,0,0,0,2,2,0,2,2,0,0,0,0,2,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,2,0,2,2,2,2,2,2,2,2,2,2,2,0,2,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,2,0,2,2,2,2,2,2,2,2,2,2,2,0,2,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,2,0,2,2,3,3,3,3,3,3,3,2,2,0,2,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,2,2,2,2,3,3,3,4,3,3,3,2,2,2,2,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,2,2,2,2,3,3,3,3,3,3,3,2,2,2,2,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,2,0,2,2,3,3,3,3,3,3,3,2,2,0,2,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,2,0,2,2,2,2,2,2,2,2,2,2,2,0,2,2,0,0,0,0,0,0},
        {0,0,0,0,0,0,2,2,0,2,2,2,2,2,2,2,2,2,2,2,0,2,2,0,0,0,0,0,0},
               
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,2,0,0,0,2,2,0,0,0,0,2,2,0,2,2,0,0,0,0,2,2,0,0,0,2,2,0},
        {0,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2,2,2,2,0},
        {0,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2,2,2,2,0},
        {0,0,0,2,2,0,2,2,0,2,2,0,0,0,0,0,0,0,2,2,0,2,2,0,2,2,0,0,0},
        {0,2,2,2,2,2,2,2,0,2,2,2,2,2,0,2,2,2,2,2,0,2,2,2,2,2,2,2,0},
        {0,2,2,2,2,2,2,2,0,2,2,2,2,2,0,2,2,2,2,2,0,2,2,2,2,2,2,2,0},
        {0,2,2,0,0,0,0,0,0,0,0,0,2,2,0,2,2,0,0,0,0,0,0,0,0,0,2,2,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    
    public static int[][] energyStatus = 
    {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,0,0,0,1,1,0,0,0,0,1,1,0,1,1,0,0,0,0,1,1,0,0,0,1,1,0},
        {0,1,1,0,0,0,1,1,0,0,0,0,1,1,0,1,1,0,0,0,0,1,1,0,0,0,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,1,1,0},
        {0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0},

        {0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0},

        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,0,0,0,1,1,0,0,0,0,1,1,0,1,1,0,0,0,0,1,1,0,0,0,1,1,0},
        {0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0},
        {0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0},
        {0,0,0,1,1,0,1,1,0,1,1,0,0,0,0,0,0,0,1,1,0,1,1,0,1,1,0,0,0},
        {0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0},
        {0,1,1,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,0,0,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };   
    
    static JLabel mapView[][] = new JLabel[width][height];
    
    
    /**
     * This function is ran when all of the pineapples (energy) have been eaten by the dino.
     * gameWon is called to end the game by displaying a new screen congratulating the player and then ending the program.
     */
    public static void gameWon()
    {
        //Create the winning screen
        win = new JFrame();
        win.setSize((height * 25), (width*25));
        win.setResizable(false);
        win.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel wonImage = new JLabel();
        wonImage.setIcon(new ImageIcon(Window.class.getResource("/youWon.jpg")));
        win.add(wonImage);
        
        //Switch out game for the won game for the winning screen
        win.setVisible(true);
        box.setVisible(false);
    }
    
    /**
     * This function is ran when a meteor hits a dino, or a dino hits a meteor.
     * gameLost is then called to end the game by displaying a new screen informing the player that they have lost and then ending the program.
     */
    public static void gameLost()
    {
        //Create losing screen
        lose = new JFrame();
        lose.setSize((height * 25), (width*25));
        lose.setResizable(false);
        lose.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel lostImage = new JLabel();
        lostImage.setIcon(new ImageIcon(Window.class.getResource("/youLost.jpg")));
        lose.add(lostImage);
        
        //Switch out game for the losing screen
        lose.setVisible(true);
        box.setVisible(false);
        
    }
    
    /**
     * The setMapPosition function take two coordinates and the integer representation of the object you want to place at that location.
     * It then adds that object representation number to that location in the gameMap that will be shown on the screen.
     * @param x
     * @param y
     * @param c
     */
    public static void setMapPosition(int x, int y, int c)
    {
        gameMap[x][y] = c;
    }
    
    /**
     * The getMapItem function takes two coordinates, it then finds the integer stored at that location within the gameMap array
     * and passes back that integer.
     * @param x
     * @param y
     * @return objectType
     */
    public static int getMapItem(int x, int y)
    { 
        return gameMap[x][y];
    }
    
    
    /**
     * The setEnergy function take two coordinates and the integer representation of the energy status (1 = yes, 0 = no) you want to place at that location.
     * It then adds that status number to that location in the energyStatus array.
     * @param x
     * @param y
     * @param c
     */
    public static void setEnergy(int x, int y, int c)
    {
        energyStatus[x][y] = c;
    }
    
    /**
     * The getEnergy function takes two coordinates, it then finds the integer stored at that location within the energyStatus array
     * and passes back that integer. Indicating if there is energy (1) or no energy (0) at that location. 
     * @param x
     * @param y
     * @return energy status 
     */
    public static int getEnergy(int x, int y)
    {   
        return energyStatus[x][y];
    }
    
    /*
     * While creating the GUI. This function will loop through each position in the gameMap array and place an icon (image) and each position
     * in the game view according to the gameMap.
     * Each icon/label is then added to the gameBoard.
     */
    private void createMap()
    {
        int c;
        String s = "";
        
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                mapView[i][j] = new JLabel();
                c = gameMap[i][j];
                
                if(c == 0)
                    mapView[i][j].setIcon(new ImageIcon(getClass().getResource(wall)));
                if(c == 2)
                    mapView[i][j].setIcon(new ImageIcon(getClass().getResource(floorFull)));
                if(c == 3)
                    mapView[i][j].setIcon(new ImageIcon(getClass().getResource(floorEmpty)));
                if(c == 4)
                    mapView[i][j].setIcon(new ImageIcon(getClass().getResource(badGuy)));
                if(c == 5)
                    mapView[i][j].setIcon(new ImageIcon(getClass().getResource(heroR)));
                
                content.add(mapView[i][j]);
            }
        }
    }
    
    /*
     * This function is called from the keyListener. It is passed two coordinates.
     * Those parameters are passed to the dino object so it can be moved accordingly. 
     * All of the meteors are then moved on the board.
     * Once all objects have been moved, and the game has not been won, then the map is redrawn with the updated moves.
     */
    private void moveCharacters(int x, int y)
    {
        BadGuy b;
        dino.changePosition(x, y);
        
        for(int i = 0; i < v.size(); i++)
        {
            b = (BadGuy) v.get(i); 
            b.changeDirection();
        }
        
        checkForWin();
        drawMap();
    }
    
    /*
     * This function loops through the energyStatus array. If if finds energy (1) then it returns. 
     * If it does not find energy, then the whole board has been cleared by the dino and gameWon is called. 
     */
    private void checkForWin() 
    {
        boolean winner = false;
        
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {   
                if(getEnergy(i, j) == 1)
                    return;
                
                else
                    winner = true;
            }
        }
        
        if(winner)
            gameWon();
    }
    
    /*
     * Similare to createMap, except instead of creating objects. It redraws each position in the mapView array with the current gameMap array.
     */
    private void drawMap() 
    {
        int c;
        
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {     
                c = gameMap[i][j];
                
                if(c == 0)
                    mapView[i][j].setIcon(new ImageIcon(getClass().getResource(wall)));
                if(c == 2)
                    mapView[i][j].setIcon(new ImageIcon(getClass().getResource(floorFull)));
                if(c == 3)
                    mapView[i][j].setIcon(new ImageIcon(getClass().getResource(floorEmpty)));
                if(c == 4)
                    mapView[i][j].setIcon(new ImageIcon(getClass().getResource(badGuy)));
                if(c == 5)
                    mapView[i][j].setIcon(new ImageIcon(getClass().getResource(dino.getImage())));
                
                content.add(mapView[i][j]);
            }
        }
    }
    
    /**
     * This constructor created the GUI for the pacman-dino style game.
     */
    public Window()
    {

        box = new JFrame();
        FlowLayout layout = new FlowLayout();
        
        box.setSize((height * 25), (width*25));
        box.setResizable(false);
        box.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        layout.setHgap(0);  
        layout.setVgap(0);  
        
        content = box.getContentPane(); 
        content.setLayout(layout);
        
        dino = new Hero();
        
        //Holds all of the bad guy elements
        v = new Vector();
        v.addElement(new BadGuy(14, 14));
        v.addElement(new BadGuy(10, 21));
        v.addElement(new BadGuy(5, 1));
        v.addElement(new BadGuy(23, 1));
        
        createMap();
        
        box.addKeyListener(this); //Accepts input from the arrow keys
        
        box.setVisible(true);
    }

    /**
     * Listens for a key pressed by the user. If they press one of the arrow keys, the function for moving the objects is called.
     * @param event 
     */
    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP) 
        {
            moveCharacters(-1, 0);
        }
        
        if (event.getKeyCode() == KeyEvent.VK_DOWN) 
        {
            moveCharacters(1, 0);
        }
        
        if (event.getKeyCode() == KeyEvent.VK_LEFT) 
        {
            moveCharacters(0, -1);
        }
        
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
        {
            moveCharacters(0, 1);
        }
    }

    /**
     * Override function, nothing will happen in the game if this is activated, game will continue normally.
     * @param ke
     */
    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Override function, nothing will happen in the game if this is activated, game will continue normally.
     * @param ke
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
