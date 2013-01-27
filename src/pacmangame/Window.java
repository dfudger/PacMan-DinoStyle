/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmangame;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;


/**
 *
 * @author dfudger
 */
public class Window extends JFrame implements Actionlistener
{
    
    
    static JLabel mapView[][] = new JLabel[10][10];
    public static final int width = 6;
    public static final int height = 8;
    
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
        //box.setLayout(new FlowLayout()); //Set the type of layout for window
        
        //gamepanel.setLayout(new GridLayout(6, 8));
        
        //box.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
        //gamepanel.setHgap(0);
        
        //matteborder gamepanelBroder = new matteborder(0, 0, 0, 0, Color.black);
        //Dimension d1 = new Dimension(850, 650);
        //gamepanel.setPreferredSize(d1);
        
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
        
        
        //box.add(gamepanel);
        
        box.setVisible(true);
    }
    
}
