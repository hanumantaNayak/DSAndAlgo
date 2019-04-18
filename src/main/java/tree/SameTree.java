package tree;

public class SameTree {
    public boolean sameTree(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return root1.getData() == root2.getData() &&
               sameTree(root1.getLeft(), root2.getLeft()) &&
               sameTree(root1.getRight(), root2.getRight());
    }
    public static void main(String args[]){
        BinaryTree bt1 = new BinaryTree();
        bt1.addNode(10);
        bt1.addNode(20);
        bt1.addNode(15);
        bt1.addNode(2);

        BinaryTree bt2 = new BinaryTree();
        bt2.addNode(10);
        bt2.addNode(20);
        bt2.addNode(15);
        bt2.addNode(2);

        SameTree st = new SameTree();
        System.out.println("Tree's are same : "+st.sameTree(bt1.getRoot(), bt2.getRoot()));
    }
}
