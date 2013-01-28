/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
    public Container content;
    
    /***Image Strings***/
    public static String wall = "images/wall.jpg";
    public static String floorFull = "images/floorFull.jpg";
    public static String floorEmpty = "images/floorEmpty.jpg";
    public static String hero = "images/hero.jpg";
    public static String badGuy = "images/badGuy.jpg";
    public static final int width = 31;
    public static final int height = 29;
    
    public Vector v;
    
    /***Map Arrays***/
    public static int[][] gameMap = 
    {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,5,2,2,2,2,2,2,2,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
        {0,2,2,0,0,0,2,2,0,0,0,0,2,2,0,2,2,0,0,0,0,2,2,0,0,0,2,2,0},
        {0,2,2,0,0,0,2,2,0,0,0,0,2,2,0,2,2,0,0,0,0,2,2,0,0,0,2,2,0},
        {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
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
    
    
    
    public static void setMapPosition(int x, int y, int c)
    {
        gameMap[x][y] = c;
    }
    
    public static int getMapItem(int x, int y)
    { 
        return gameMap[x][y];
    }
    
    
    public static void setEnergy(int x, int y, int v)
    {
        energyStatus[x][y] = v;
    }
    
    public static int getEnergy(int x, int y)
    {   
        return energyStatus[x][y];
    }
    
    private void createMap()
    {
        int c;
        String s = "";
        
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                mapView[i][j] = new JLabel();
                //System.out.println("GAA: " + i + j);
                //System.out.println("Game Map: " + gameMap[i].charAt(j));
                //s = gameMap[i];
                c = gameMap[i][j];
                
                if(c == 0)
                   // System.out.println("HEre");
                    mapView[i][j].setIcon(new ImageIcon(wall));
                    //System.out.println("There");
                
                    
                if(c == 2)
                    mapView[i][j].setIcon(new ImageIcon(floorFull));
                if(c == 3)
                    mapView[i][j].setIcon(new ImageIcon(floorEmpty));
                if(c == 4)
                    mapView[i][j].setIcon(new ImageIcon(badGuy));
                if(c == 5)
                    mapView[i][j].setIcon(new ImageIcon(hero));
                
                content.add(mapView[i][j]);
            }
        }
    }
    
    
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
    
    private void checkForWin() 
    {
        boolean win = false;
        
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {   
                if(getEnergy(i, j) == 1)
                {
                    System.out.println("No win yet\n");
                    return;
                }
                else
                {
                    win = true;
                }
            }
        }
        
        if(win)
            System.out.println("\nYou Win!\n");
    }
    
    private void drawMap() 
    {
        int c;
        
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {     
                c = gameMap[i][j];
                
                if(c == 0)
                    mapView[i][j].setIcon(new ImageIcon(wall));
                if(c == 2)
                    mapView[i][j].setIcon(new ImageIcon(floorFull));
                if(c == 3)
                    mapView[i][j].setIcon(new ImageIcon(floorEmpty));
                if(c == 4)
                    mapView[i][j].setIcon(new ImageIcon(badGuy));
                if(c == 5)
                    mapView[i][j].setIcon(new ImageIcon(dino.getImage()));
                
                content.add(mapView[i][j]);
            }
        }
    }
    
    
    public Window()
    {

        JFrame box = new JFrame();
        FlowLayout layout = new FlowLayout();
        
        box.setSize((height * 25), (width*25));
        box.setResizable(false);
        box.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        layout.setHgap(0);  
        layout.setVgap(0);  
        
        content = box.getContentPane(); 
        content.setLayout(layout);
        
        dino = new Hero();
        
        v = new Vector();
        v.addElement(new BadGuy(14, 14));
        v.addElement(new BadGuy(10, 21));
        
        createMap();
        
        box.addKeyListener(this); //Accepts input from the arrow keys
       
        box.setVisible(true);
    }

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

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }


    


}
