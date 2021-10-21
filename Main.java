import javax.swing.JFrame;
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args)
    {
        int frameHeight = 800;
        int frameWidth = 800;
        JFrame frame = new JFrame();
        int[] in =  {5,4,3,2,1};
        draw sim = new draw(in);
        
        frame.add(sim);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameHeight,frameWidth);
        
        
        
        
    
    
    }
    
    
    
}
