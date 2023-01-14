import java.awt.*;
import javax.imageio.*;
import java.awt.event.*;
import javax.swing.*;
public class BSTGraphicsFrame extends JFrame implements ActionListener, KeyListener {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static BinarySearchTree tree;
    BSTGraphicsPanel panel;
    public JTextField t;
    public JButton addBtn, delBtn;
    public BSTGraphicsFrame(String name){
        super(name);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        tree = new BinarySearchTree();
        panel = new BSTGraphicsPanel();
        t = new JTextField("5 1 3 7 10 6 0");
        t.setPreferredSize(new Dimension(150, 30));
        t.setLocation(1600, 25);
        //t.addKeyListener(this);
        addBtn = new JButton("Add");
        addBtn.addActionListener(this);
        delBtn = new JButton("Remove");
        delBtn.addActionListener(this);
        panel.add(t);
        panel.add(delBtn);
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
    public void actionPerformed(ActionEvent ev) {
        // TODO Auto-generated method stub
            if (t.isEnabled()) {
            try {
                String[] s = t.getText().split(" ");
                if (ev.getSource() == addBtn) {
                    for (int i = 0; i < s.length; i++) {
                        tree.Add(Integer.parseInt(s[i]), 860, 50, 0);
                    }
                    
                } else {
                    for (int i = 0; i < s.length; i++) {
                        tree.remove(Integer.parseInt(s[i]));
                    }
                    tree.reArrangeAAAAAAAAAAAAAA();
                }
                t.setText("");
                //t.requestFocusInWindow();
                repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please Enter Integer.");
            }
        }
    }
}
