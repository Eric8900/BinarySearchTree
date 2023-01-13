import java.awt.*;
import javax.imageio.*;
import java.awt.event.*;
import javax.swing.*;
public class BSTGraphicsFrame extends JFrame implements ActionListener, KeyListener {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public BSTGraphicsFrame(String name, BinarySearchTree tree){
        super(name);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        BSTGraphicsPanel panel = new BSTGraphicsPanel(tree);
        JTextField t = new JTextField("");
        t.setFont(new Font("Arial", Font.BOLD, 20));
        t.setPreferredSize(new Dimension(150, 30));
        t.addKeyListener(this);
        JButton addBtn = new JButton("Add");
        addBtn.setFont(new Font("Arial", Font.BOLD, 20));
        addBtn.addActionListener(this);
        panel.add(t);
        panel.add(addBtn);  

        add(panel);
        setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
