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
    public void setRoot(Node node){
        this.root = node;
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

    public void display(){
        if(this.root == null){
            System.out.println("Tree is empty!");
            return;
        }
        display(this.root);
    }
    public void display(Node node){
        if(node == null)
            return;
        System.out.print(node.getData()+" ");
        display(node.getLeft());
        display(node.getRight());
    }
}

