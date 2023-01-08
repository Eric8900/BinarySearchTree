public class BinaryNode {
    private int value;
    private BinaryNode left;
    private BinaryNode right;
    public BinaryNode parent;
    public int x;
    public int y;

    public BinaryNode(int val, int x, int y, BinaryNode parent) {
        value = val;
        left = null;
        right = null;
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public BinaryNode(int val, BinaryNode l, BinaryNode r) {
        value = val;
        left = l;
        right = r;
    }
    public BinaryNode getLeft() {
        return left;
    }
    public int getValue() {
        return value;
    }
    public BinaryNode getRight() {
        return right;
    }
    public void setLeft(BinaryNode l) {
        left = l;
    }
    public void setValue(int val) {
        value = val;
    }
    public void setRight(BinaryNode r) {
        right = r;
    }
}
