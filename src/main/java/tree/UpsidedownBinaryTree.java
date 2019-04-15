package tree;

public class UpsidedownBinaryTree {
    public Node upsidedownBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        return upsidedownBinaryTree(root, null, null);
    }

    private Node upsidedownBinaryTree(Node root, Node parent, Node rightChild) {

        if (root == null) {
            return parent;
        }
        Node left = root.getLeft();
        Node right = root.getRight();
        root.setRight(parent);
        root.setLeft(rightChild);
        return upsidedownBinaryTree(left, root, right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.addNode(3);
        bt.addNode(-6);
        bt.addNode(-7);
        bt.addNode(2);
        bt.addNode(9);
        bt.addNode(6);
        bt.addNode(11);
        bt.addNode(13);
        bt.addNode(12);
        System.out.println("Original Tree");
        bt.display();
        System.out.println("\nUpside down tree");
        UpsidedownBinaryTree upsideTree = new UpsidedownBinaryTree();
        upsideTree.upsidedownBinaryTree(bt.getRoot());
        bt.display();
    }
}

