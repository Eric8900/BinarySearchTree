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
                    p.setLeft(new BinaryNode(n, p.x - 400, y + 75, p));
                }
                else p.setLeft(new BinaryNode(n, p.x - (Math.abs(p.parent.x - p.x) / 2) , y + 100, p));
            }
            else {
                depth++;
                Add(p.getLeft(), n, x - 150, y + 150, depth);
            }
        }
        else {
            if (p.getRight() == null) {
                if (depth == 1) {
                    p.setRight(new BinaryNode(n, p.x + 400, y + 75, p));
                }
                else p.setRight(new BinaryNode(n, p.x + (Math.abs(p.parent.x - p.x) / 2), y + 100, p));
            }
            else {
                depth++;
                Add(p.getRight(), n, x + 150, y + 150, depth);
            }
        }
    }

    public void remove(int k) {
        if (root == null) return;
        if (root.getValue() == k) {
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }
            else if (root.getLeft() == null) {
                root = root.getRight();
                return;
            }
            else if (root.getRight() == null) {
                root = root.getLeft();
                return;
            }
            else {
                BinaryNode inOrderSuc = successor(root);
                swap(root, inOrderSuc);
                if (root.getRight() == inOrderSuc) {
                    root.setRight(inOrderSuc.getRight());
                    inOrderSuc.setRight(null);
                    return;
                }
                remove(root.getRight(), k);
            }
        }
        remove(root, k);
    }

    private BinaryNode remove(BinaryNode start, int k) {
        BinaryNode nodeToRemove, inorderSuccessor;
        BinaryNode parent = search(start, k);

        if (parent == null) return null;

        boolean isLeft = parent.getLeft() != null && parent.getLeft().getValue() == k;
        nodeToRemove = isLeft ? parent.getLeft() : parent.getRight();
        if(nodeToRemove.getLeft() == null && nodeToRemove.getRight() == null) {
            if(isLeft)
                parent.setLeft(null);
            else
                parent.setRight(null);
            return nodeToRemove;
        }
        else if(nodeToRemove.getLeft() == null) {
            if(isLeft)
                parent.setLeft(nodeToRemove.getRight());
            else
                parent.setRight(nodeToRemove.getRight());
            nodeToRemove.setRight(null);
            return nodeToRemove;
        }
        else if(nodeToRemove.getRight() == null) {
            if(isLeft)
                parent.setLeft(nodeToRemove.getLeft());
            else
                parent.setRight(nodeToRemove.getLeft());
            nodeToRemove.setLeft(null);
            return nodeToRemove;
        }
        else {
            inorderSuccessor = successor(nodeToRemove);
            swap(inorderSuccessor, nodeToRemove);
            if(nodeToRemove.getRight()==inorderSuccessor)
            {
                nodeToRemove.setRight(inorderSuccessor.getLeft());
                inorderSuccessor.setRight(null);
                return inorderSuccessor;
            }
        return remove(nodeToRemove.getRight(), k);
        }
    }

    public BinaryNode search(BinaryNode s, int k) {
        if (s == null) return null;
        if (s.getLeft() != null && s.getLeft().getValue() == k || s.getRight() != null && s.getRight().getValue() == k) {
            return s;
        }
        else if (k < s.getValue()) {
           return search(s.getLeft(), k);

        }
        else {
            return search(s.getRight(), k);
        }
    }

    private BinaryNode successor(BinaryNode k) {
        BinaryNode temp = k.getRight();
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp;
    }
    
    private void swap(BinaryNode a, BinaryNode b) {
        int temp = a.getValue();
        a.setValue(b.getValue());
        b.setValue(temp);
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
    public int height(BinaryNode p) {
        if (p != null) {
            return 1 + Math.max(height(p.getLeft()), height(p.getRight()));
        }
        return 0;
    }
    public int width() {  
        int maxWidth = 0;  
        int nodesInLevel = 0;  
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();  
        if(root == null) {
            return 0;  
        }  
        else {
            queue.add(root);  

            while(queue.size() != 0) {  
                nodesInLevel = queue.size();   
                maxWidth = Math.max(maxWidth, nodesInLevel);  
                while(nodesInLevel > 0) {  
                   BinaryNode current = queue.remove();  
                   if(current.getLeft() != null)  
                       queue.add(current.getLeft());  
                   if(current.getRight() != null)  
                       queue.add(current.getRight());  
                   nodesInLevel--;  
                }  
            }  
        }  
        return maxWidth;  
    }
    public int diameter() {
        return height(root.getRight()) + height(root.getLeft()) + 1;
    }
}
