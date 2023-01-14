import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.Queue;

import javax.imageio.*;
import javax.swing.*;
public class BSTGraphicsPanel extends JPanel {
    public BSTGraphicsPanel() {
    }
    public void paint(Graphics g) {
        super.paintComponents(g);
        g.setFont(new Font("Times New Roman", 1, 20));
        g.setColor(new Color(108, 32, 139));
        g.drawString("Max Accurate Depth: 5", 20, 100);
        g.drawString("Enter in single integers or multiple integers to add or delete \n Example: 5 1 3 7 10 6 0 ---->", 20, 25);
        if (BSTGraphicsFrame.tree.getRoot() != null) {
            Queue<BinaryNode> q = new LinkedList<>();
            q.add(BSTGraphicsFrame.tree.getRoot());
            while (!q.isEmpty()) {
                BinaryNode p = q.poll();
                if (p != null) {
                    //System.out.println(p.x + " " + p.y + " " + p.getValue());
                    g.setColor(new Color(108, 32, 139));
                    if (p.parent != null) {
                        g.drawLine(p.x + 10, p.y + 20, p.parent.x + 10, p.parent.y + 20);
                    }
                    g.fillRect(p.x, p.y, 35, 25);
                    g.setColor(new Color(188, 228, 255));
                    g.setFont(new Font("Times New Roman", 1, 20 - ((p.digitsX() - 1) * 2)));
                    g.drawString("" + p.getValue(), p.x + 2, p.y + 20);
                    if (p.getLeft() != null) q.add(p.getLeft());
                    if (p.getRight() != null) q.add(p.getRight());
                }
            }
            g.setColor(new Color(30, 50, 240));
            g.setFont(new Font("Times New Roman", 1, 15));
            g.drawString("Preorder Representation: " + BSTGraphicsFrame.tree.preOrder(BSTGraphicsFrame.tree.getRoot()), 100, getHeight() - 50);
            g.drawString("Height: " + (BSTGraphicsFrame.tree.height(BSTGraphicsFrame.tree.getRoot()) - 1), 20, 125);
            g.drawString("Width: " + BSTGraphicsFrame.tree.width(), 20, 150);
            g.drawString("Diameter: " + BSTGraphicsFrame.tree.diameter(), 20, 175);
        }
    }
    
}
//1000 500 1500 750 250 300 100 600 800 1400 1200 1450 1470 1425 1100 1250 1600 1502 1501 1503 1602 1603 1601 50 200 550 700 760 850 25 20 860 1050
