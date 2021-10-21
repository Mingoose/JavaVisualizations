import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
/**
 * Write a description of class doublePen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class doublePen extends JPanel
{   
    double x1;
    double y1;

    double x2;
    double y2;

    double r1=150;
    double r2=150;

    double a1=(double)Math.PI/2;
    double a2=(double)Math.PI/2;

    double gr = 2;
    double m1 = 20;
    double m2 = 20;
    double a1_v = 0;
    double a2_v= 0; 
    int frameHeight = 800;
    int frameWidth = 800;
    int xshift = frameWidth/2;
    int yshift = frameHeight/2;
    ArrayList<point> pts = new ArrayList<point>();
    double totalEnergy = m1*gr*r1 + m2*gr*(r1+r2);
    public static void main(String[] args)
    {
        new doublePen();
    }

    public doublePen()
    {}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        double num1 = -gr * (2 * m1 + m2) * (double)Math.sin(a1);
        double num2 = -m2 * gr * (double)Math.sin(a1 - 2 * a2);
        double num3 = -2 * (double)Math.sin(a1 - a2) * m2;
        double num4 = a2_v * a2_v * r2 + a1_v * a1_v * r1 * (double)Math.cos(a1 - a2);
        double den = r1 * (2 * m1 + m2 - m2 * (double)Math.cos(2 * a1 - 2 * a2));
        double a1_a = (num1 + num2 + num3 * num4) / den;

        double num5 = 2 * (double)Math.sin(a1 - a2);
        double num6 = (a1_v * a1_v * r1 * (m1 + m2));
        double num7 = gr * (m1 + m2) * (double)Math.cos(a1);
        double num8 = a2_v * a2_v * r2 * m2 * (double)Math.cos(a1 - a2);
        double den2 = r2 * (2 * m1 + m2 - m2 * (double)Math.cos(2 * a1 - 2 * a2));
        double a2_a = (num5 * (num6 + num7 + num8)) / den2;
       
        //a1_a = (-m2*Math.cos(a1-a2)*r1*a1_v*a1_v*Math.sin(a1-a2)+m2*Math.cos(a1-a2)*gr*Math.sin(a2)-m2*r2*a2_v*a2_v*Math.sin(a1-a2)-(m1+m2)*gr*Math.sin(a1))/(r1*(m1+m2-m2*Math.cos(a1-a2)*Math.cos(a1-a2)));
        //a2_a = ((m1+m2)*(r1*a1_v*a1_v*Math.sin(a1-a2)+(a2_v*a2_v*Math.sin(a1-a2)*Math.cos(a1-a2)*m2*r2)/(m1+m2) + Math.cos(a1-a2)*gr*Math.sin(a1)-gr*Math.sin(a2) ) )/(r2*(m1+m2*Math.sin(a1-a2)*Math.sin(a1-a2)));
        a1_v += a1_a;
        a2_v += a2_a;
        a1 += a1_v;
        a2 += a2_v;
        
        
        
        
        x1 = r1 * (double)Math.sin(a1);
        y1 = r1 * (double)Math.cos(a1);

        x2 = x1 + r2 * (double)Math.sin(a2);
        y2 = y1 + r2 * (double)Math.cos(a2);
       
        g2.drawLine(frameWidth/2,yshift,(int)x1 + xshift,(int)y1+yshift);
        g2.drawLine((int)x1 + xshift,(int)y1+yshift,(int)x2 + xshift,(int)y2+yshift);
        g2.fillOval((int)(x1 + xshift-m1/2),(int)(y1+yshift-m1/2),(int)m1,(int)m1);
        g2.fillOval((int)(x2 + xshift-m2/2),(int)(y2+yshift-m2/2),(int)m2,(int)m2);
        
        pts.add(new point((int)x2+xshift,(int)y2+yshift));
        for(int n = 0;n<pts.size();n++)
        {
            g2.setColor(new Color(255,0,0)); 
            if(n==0)
            g2.drawOval(pts.get(n).x,pts.get(n).y,1,1);
            else
            {g2.drawLine(pts.get(n).x,pts.get(n).y,pts.get(n-1).x,pts.get(n-1).y);}
        }
         try {
             Thread.sleep(5);
         } catch (InterruptedException e) {

         }
        repaint();
    }
}
