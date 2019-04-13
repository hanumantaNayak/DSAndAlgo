package tree;

public class IsBST {
    //T(n) : O(n)
    //S(n) : O(1) if Function Call Stack size is not considered, otherwise O(n)
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(10);
        bt.addNode(15);
        bt.addNode(-10);
        bt.addNode(17);
        bt.addNode(20);
        bt.addNode(0);
        //  bt.getRoot().setLeft(new Node(20));
        // bt.getRoot().setRight(new Node(5));
        IsBST isBST = new IsBST();
        if (isBST.isBST(bt.getRoot()))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.getData() >= min && root.getData() < max)
            return isBST(root.getLeft(), min, root.getData()) && isBST(root.getRight(), root.getData(), max);
        return false;
    }
}
