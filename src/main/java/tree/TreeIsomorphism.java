package tree;

public class TreeIsomorphism {
    public void areIsomorphicTrees(Node root1, Node root2){
        if(isomorphicTrees(root1, root2))
            System.out.println("Yes, Isomorphic trees.");
        else
            System.out.println("No.");
    }
    private boolean isomorphicTrees(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return root1.getData() == root2.getData() &&
               ((isomorphicTrees(root1.getLeft(), root2.getLeft()) && isomorphicTrees(root1.getRight(), root2.getRight()))
                 ||(isomorphicTrees(root1.getLeft(),root2.getRight())&& isomorphicTrees(root1.getRight(),root2.getLeft())));
    }
    public static void main(String args[]){
        int in1[] = {8,5,6,10,11,9,12};
        int pre1[] = {10,5,8,6,9,11,12};
        int in2[] = {11,9,12,10,6,5,15};
        int pre2[] = {10,9,11,12,5,6,15};
        //TODO
        //ConstructTreeFromInOrderPreOrder ct = new ConstructTreeFromInOrderPreOrder();
        //Node root1 = ct.createTree(in1, pre1);
        // Node root2 = ct.createTree(in2, pre2);
        TreeIsomorphism ti = new TreeIsomorphism();
    }
}
