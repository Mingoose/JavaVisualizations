import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
/**
 * Write a description of class draw here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class draw extends JPanel

{
    int[] in;
    
    public draw(int[] in)
    {
        this.in = in;
        sort();
    }
    
    public void paintComponent(Graphics g){
        int width = 600/in.length;
        for(int n = 0; n <in.length; n++)
        {
            g.fillRect(100 + width*n, 0, width,in[n]*100);
        }
        try {
              Thread.sleep(200);
          } catch (InterruptedException e) {

          }
    }
    
     public void sort()
    {
        
        boolean check = true;
        while (check)
        {
            check = false;
            for(int n = 0; n < in.length-1; n++)
            {
                repaint();
               
                if(in[n] > in[n+1])
                {
                    int holder = in[n+1];
                    in[n+1] = in[n];
                    in[n] = holder;
                    check = true;
                }
                
            }
        }
        
    }
}
