import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter in integers on a single line with spaces \n Example: 1 2 3 4 5 \n Note: After A Depth of 5 or 6, the drawing may have some overlap or go off screen!");
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        BinarySearchTree tree = new BinarySearchTree(nums);
        //System.out.print(tree.preOrder(tree.getRoot(), 0));
        BSTGraphicsFrame frame = new BSTGraphicsFrame("Binary Search Tree", tree);
    }
}