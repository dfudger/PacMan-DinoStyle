/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmangame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;


/**
 *
 * @author dfudger
 */
public class Window extends JFrame implements KeyListener
{
    
    
    static JLabel mapView[][] = new JLabel[10][10];
    public static final int width = 6;
    public static final int height = 8;
    
    private void addWalls(Container content)
    {
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                mapView[i][j] = new JLabel();
                if(i == 0 || i == width-1 || j == 0 || j == height-1 )
                {
                    
                    mapView[i][j].setIcon(new ImageIcon(Map.wall)); 
                    System.out.println("map[" + i + "][" + j + "] = " + Map.wall);
                }
                
                else
                {
                    mapView[i][j].setIcon(new ImageIcon(Map.floorFull));
                    System.out.println("map[" + i + "][" + j + "] = " + Map.floorFull);
                }
                
                content.add(mapView[i][j]);
                //layout.add(mapView[i][j]);
                //gamepanel.add(mapView[i][j]);
            }
        }
        
    }
    
    private void addBarriers(Container content)
    {
        mapView[4][5].setIcon(new ImageIcon(Map.wall)); 
    }
            
    private void addHero(Container content)
    {
        mapView[1][1].setIcon(new ImageIcon(Map.hero)); 
    }
    
    private void createMap(Container content)
    {
        addWalls(content);
        addBarriers(content);
        addHero(content);
    }
    
    public Window()
    {
        //Box to hold GUI
        //JPanel gamepanel = new JPanel();
        JFrame box = new JFrame();
        FlowLayout layout = new FlowLayout();
        JLabel floorLabel = new JLabel();
        box.setSize((height * 100), (width*100));
        //box.setBounds(850, 850, 650, 650); // Size
        box.setResizable(false);
        box.setDefaultCloseOperation(EXIT_ON_CLOSE); //Use X to close
        //box.setPreferredSize(new Dimension(650, 850));
        //box.setLayout(new GridLayout(6, 8));
        layout.setHgap(0);  
        layout.setVgap(0);  
        
        Container content = box.getContentPane(); 
        content.setLayout(layout);
        //content.addKeyListener(new );
        //box.setLayout(new FlowLayout()); //Set the type of layout for window
        
        //gamepanel.setLayout(new GridLayout(6, 8));
        
        //box.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        //gamepanel.setHgap(0);
        
        //matteborder gamepanelBroder = new matteborder(0, 0, 0, 0, Color.black);
        //Dimension d1 = new Dimension(850, 650);
        //gamepanel.setPreferredSize(d1);
        
        //Add Walls
        createMap(content);
        
        
        box.addKeyListener(this);
        //{
              //When any key is pressed and released then the 
              //keyPressed and keyReleased methods are called respectively.
              //The keyTyped method is called when a valid character is typed.
              //The getKeyChar returns the character for the key used. If the key
              //is a modifier key (e.g., SHIFT, CTRL) or action key (e.g., DELETE, ENTER)
              //then the character will be a undefined symbol.
             // @Override 
             // public void keyPressed(KeyEvent e)
             /* {
                  System.out.println("Key Pressed: " + e.getKeyChar() + "\n");
              }
              @Override
              public void keyReleased(KeyEvent e)
              {
                  System.out.println("Key Released: " + e.getKeyChar() + "\n");
              }*/
              
              //@Override
              /*public void keyTyped(KeyEvent e)
              {
                  //The getKeyModifiers method is a handy
                  //way to get a String representing the
                  //modifier key.
                  System.out.println("Key Typed: " + e.getKeyChar() + " " + KeyEvent.getKeyModifiersText(e.getModifiers()) + "\n");
              } */
            /*  
              public void keyTyped(KeyEvent event) 
              {
                if (event.getKeyCode() == KeyEvent.VK_UP) 
                {
                    System.out.println("UP!\n\n");
                }
                if (event.getKeyCode() == KeyEvent.VK_DOWN) 
                {
                    System.out.println("DOWN!\n\n");
                }
                if (event.getKeyCode() == KeyEvent.VK_LEFT) 
                {
                    System.out.println("LEFT!\n\n");
                }
                if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
                {
                    System.out.println("RIGHT!\n\n");
                }
              }*/
        //});
        
       
        
        //box.add(gamepanel);
        
        box.setVisible(true);
    }
    
    //@Override
    //public void keyTyped(KeyEvent event) {
        
    //}

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP) 
                {
                    System.out.println("UP!\n\n");
                }
                if (event.getKeyCode() == KeyEvent.VK_DOWN) 
                {
                    System.out.println("DOWN!\n\n");
                }
                if (event.getKeyCode() == KeyEvent.VK_LEFT) 
                {
                    System.out.println("LEFT!\n\n");
                    mapView[1][1].setIcon(new ImageIcon(Map.hero));
                    mapView[1][2].setIcon(new ImageIcon(Map.floorEmpty));
                }
                if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
                {
                    System.out.println("RIGHT!\n\n");
                    mapView[1][2].setIcon(new ImageIcon(Map.hero));
                    mapView[1][1].setIcon(new ImageIcon(Map.floorEmpty));
                    
                }
    }

    //@Override
    //public void keyReleased(KeyEvent ke) {
      //  throw new UnsupportedOperationException("Not supported yet.");
    //}

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }


    


}
