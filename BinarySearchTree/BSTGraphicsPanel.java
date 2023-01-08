import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.Queue;

import javax.imageio.*;
import javax.swing.*;
public class BSTGraphicsPanel extends JPanel {
    private BinarySearchTree tree;
    private int[] n;
    public BSTGraphicsPanel(BinarySearchTree tree) {
        this.tree = tree;
        n = tree.originalNums;
        for (int i = 0; i < n.length; i++) {
            tree.Add(n[i], 860, 50, 0);
        }
    }
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Times New Roman", 1, 20));
        // each node will be 100x100
        // each "level" of BST will be y+=150
        /*if (first) {
            first = false;
            search(tree.getRoot());
        }*/
        g.drawString("Max Accurate Depth: 5", 20, 100);
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(tree.getRoot());
        while (!q.isEmpty()) {
            BinaryNode p = q.poll();
            if (p != null) {
                //System.out.println(p.x + " " + p.y + " " + p.getValue());
                g.drawRect(p.x, p.y, 50, 50);
                g.drawString("" + p.getValue(), p.x + 12, p.y + 25);
                if (p.parent != null) {
                    g.drawLine(p.x + 10, p.y + 20, p.parent.x + 10, p.parent.y + 20);
                }
                if (p.getLeft() != null) q.add(p.getLeft());
                if (p.getRight() != null) q.add(p.getRight());
            }
        }
        g.setColor(new Color(30, 50, 240));
        g.setFont(new Font("Times New Roman", 1, 15));
        g.drawString("Preorder Representation: " + tree.preOrder(tree.getRoot()), 100, 25);
        //g.drawString("Height: " + tree.height(tree.getRoot()), 20, 125);
        //g.drawString("Depth: " + tree.depth(tree.getRoot()), 20, 150);
    }
}
//1000 500 1500 750 250 300 100 600 800 1400 1200 1450 1470 1425 1100 1250 1600 1502 1501 1503 1602 1603 1601 50 200 550 700 760 850 25 20 860 1050
