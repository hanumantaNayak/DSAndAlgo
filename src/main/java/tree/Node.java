package tree;

public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int value){
         init(value, null,null);
    }

    public Node (int value, Node left, Node right) {
    init(value,left,right);
    }
    private void init(int value, Node left, Node right){
            this.data = value;
            this.left= left;
            this.right=right;
        }

    public int getData(){
        return this.data;
    }
    public void setData(int value){
        this.data = value;
    }
    public Node getLeft(){
        return this.left;
    }
    public Node getRight(){
        return this.right;
    }
    public void setLeft(Node node){ this.left = node;}
    public void setRight(Node node){this.right = node;}
}
