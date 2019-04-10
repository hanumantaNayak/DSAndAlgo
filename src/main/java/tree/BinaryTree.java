package tree;

public class BinaryTree {
    private Node root;
    public BinaryTree(){
        root = null;
    }
    public BinaryTree(int data){
        root = new Node(data);
    }

    public Node getRoot(){
        return this.root;
    }

    public void addNode(int data) {
        Node node = new Node(data);
        if (this.root == null) {
            this.root = node;
            return;
        }
        Node current = this.root;
        Node prev = null;
        while (current != null) {
            prev = current;
            if (data < current.getData())
                current = current.getLeft();
            else
                current = current.getRight();
        }
        if (data < prev.getData())
            prev.setLeft(node);
        else
            prev.setRight(node);

    }
}
