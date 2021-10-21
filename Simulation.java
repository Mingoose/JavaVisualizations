import javax.swing.JFrame;
/**
 * Write a description of class IdentiforGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Simulation
{
    public static void main(String args[])
    {
        int frameHeight = 800;
        int frameWidth = 800;
        JFrame frame = new JFrame();
        doublePen sim = new doublePen();
        frame.add(sim);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameHeight,frameWidth);
        
    }
}
