/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmangame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


/**
 *
 * @author dfudger
 */
public class Window extends JFrame implements KeyListener
{
    public Hero dino;
    public Container content;
    public static String wall = "images/wall.jpg";
    public static String floorFull = "images/floorFull.jpg";
    public static String floorEmpty = "images/floorEmpty.jpg";
    public static String hero = "images/hero.jpg";
    public static String badGuy = "images/badGuy.jpg";
    
    public static int[][] gameMap = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 2, 2, 2, 2, 2, 0},
            {0, 2, 0, 0, 0, 2, 2, 0},        
            {0, 2, 2, 2, 2, 2, 2, 0},
            {0, 2, 2, 2, 2, 2, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
                    
    /*
    {"WWWWWWWW", 
                                            "WHFFFFFW", 
                                            "WFWWWFFW", 
                                            "WFFFFFFW", 
                                            "WFFFFFFW", 
                                            "WWWWWWWW", */
                                            };
    
    static JLabel mapView[][] = new JLabel[10][10];
    
    public static final int width = 6;
    public static final int height = 8;
    
    
    public void setMapPosition(int h, int v, int c)
    {
        gameMap[h][v] = c;
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
                
                if(c == 0) {
                   // System.out.println("HEre");
                    mapView[i][j].setIcon(new ImageIcon(wall));
                    //System.out.println("There");
                }
                    
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
    
    
    private void countEnergy() {}
    
    private void drawMap() 
    {
        int c;
        
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {     
                c = gameMap[i][j];
                
                if(c == 0) {
                   // System.out.println("HEre");
                    mapView[i][j].setIcon(new ImageIcon(wall));
                    //System.out.println("There");
                }
                    
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
        //content.repaint();
    }
    
    
    public Window()
    {

        JFrame box = new JFrame();
        FlowLayout layout = new FlowLayout();
        JLabel floorLabel = new JLabel();
        
        box.setSize((height * 100), (width*100));

        box.setResizable(false);
        box.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        layout.setHgap(0);  
        layout.setVgap(0);  
        
        content = box.getContentPane(); 
        content.setLayout(layout);
        
        dino = new Hero();
        
        createMap();
        
        
        box.addKeyListener(this);
       
        box.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP) 
        {
            System.out.println("UP!\n\n");
            dino.changePosition(-1, 0);
            drawMap();
        }
        
        if (event.getKeyCode() == KeyEvent.VK_DOWN) 
        {
            System.out.println("DOWN!\n\n");
            dino.changePosition(1, 0);
            drawMap();
        }
        
        if (event.getKeyCode() == KeyEvent.VK_LEFT) 
        {
            System.out.println("LEFT!\n\n");
            dino.changePosition(0, -1);
            drawMap();
            //mapView[1][1].setIcon(new ImageIcon(Map.hero));
            //mapView[1][2].setIcon(new ImageIcon(Map.floorEmpty));
        }
        
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
        {
            System.out.println("RIGHT!\n\n");
            dino.changePosition(0, 1);
            drawMap();
            //mapView[1][2].setIcon(new ImageIcon(Map.hero));
            //mapView[1][1].setIcon(new ImageIcon(Map.floorEmpty));

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
