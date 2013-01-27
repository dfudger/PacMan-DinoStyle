/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmangame;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author dfudger
 */
public class Window extends JFrame implements Actionlistener
{
    
    
    static JLabel mapView[][] = new JLabel[10][10];
    
    
    public Window()
    {
        //Box to hold GUI
        JPanel gamepanel = new JPanel();
        JFrame box = new JFrame();
        JLabel floorLabel = new JLabel();
        box.setSize(900, 900);
        box.setDefaultCloseOperation(EXIT_ON_CLOSE); //Use X to close
        
        
        box.setLayout(new FlowLayout()); //Set the type of layout for window

        gamepanel.setLayout(new GridLayout(6, 8));
        
        Dimension d1 = new Dimension(900, 900);
        gamepanel.setPreferredSize(d1);
        
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                mapView[i][j] = new JLabel();
                if(i == 0 || i == 5  )
                {
                    
                    mapView[i][j].setIcon(new ImageIcon(Map.wall)); 
                    System.out.println("map[" + i + "][" + j + "] = " + Map.wall);
                }
                
                else
                {
                    mapView[i][j].setIcon(new ImageIcon(Map.floorFull));
                    System.out.println("map[" + i + "][" + j + "] = " + Map.floorFull);
                }
                
                box.add(mapView[i][j]);
            }
        }
        
        
        box.add(gamepanel);
        
        box.setVisible(true);
    }
    
}
