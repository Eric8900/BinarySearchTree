import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
public class BSTGraphicsFrame extends JFrame {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public BSTGraphicsFrame(String name, BinarySearchTree tree){
        super(name);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        add(new BSTGraphicsPanel(tree));
        setVisible(true);
    }
}
