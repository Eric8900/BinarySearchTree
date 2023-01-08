import java.util.*;
public class BinarySearchTree {
    private BinaryNode root;
    public int[] originalNums;
    public BinarySearchTree(int[] nums) {
        originalNums = nums;
    }

    public void Add(int n, int x, int y, int depth) {
        if (root == null) {
            root = new BinaryNode(n, x, y, null);
            return;
        }
        Add(root, n, x, y, depth + 1);
    }
    // 1000 500 1500 750 250 300 100 1001
    private void Add(BinaryNode p, int n, int x, int y, int depth) {
        if (p == null) return;
        // p less than n
        else if (n < p.getValue()) {
            if (p.getLeft() == null) {
                if (depth == 1) {
                    p.setLeft(new BinaryNode(n, p.x - 450, y + 150, p));
                }
                else p.setLeft(new BinaryNode(n, p.x - (Math.abs(p.parent.x - p.x) / 2) , y + 150, p));
            }
            else {
                depth++;
                Add(p.getLeft(), n, x - 150, y + 150, depth);
            }
        }
        else {
            if (p.getRight() == null) {
                if (depth == 1) {
                    p.setRight(new BinaryNode(n, p.x + 450, y + 150, p));
                }
                else p.setRight(new BinaryNode(n, p.x + (Math.abs(p.parent.x - p.x) / 2), y + 150, p));
            }
            else {
                depth++;
                Add(p.getRight(), n, x + 150, y + 150, depth);
            }
        }
    }
    
    public BinaryNode getRoot() {
        return root;
    }
    public String preOrder(BinaryNode p) {
        String temp = "";
        if(p != null)
        {
            temp += p.getValue() + " ";
            // go left
            temp += preOrder(p.getLeft());
            // go right
            temp += preOrder(p.getRight());
        }
        return temp;
    }
}
