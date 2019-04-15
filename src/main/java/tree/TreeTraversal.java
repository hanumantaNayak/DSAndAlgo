package tree;

public class TreeTraversal {
    public void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.getLeft());
        System.out.print(root.getData()+" ");
        inOrder(root.getRight());
    }
    public void preOrder(Node root){
        if(root == null)
            return;
        System.out.print(root.getData()+" ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
    public void postOrder(Node root){
         if(root == null)
          return;
         postOrder(root.getLeft());
         postOrder(root.getRight());
        System.out.print(root.getData()+" ");
    }
    //TODO - Iterator methods
    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        bt.addNode(10);
        bt.addNode(15);
        bt.addNode(19);
        bt.addNode(17);
        bt.addNode(11);
        bt.addNode(-11);
        System.out.println("\nOriginal Tree");
        bt.display();
        TreeTraversal tt = new TreeTraversal();
        System.out.println("\n In order Traversal");
        tt.inOrder(bt.getRoot());
        System.out.println("\n Post order Traversal");
        tt.postOrder(bt.getRoot());
        System.out.println("\n Pre order Traversal");
        tt.preOrder(bt.getRoot());
        System.out.println();
    }
}
