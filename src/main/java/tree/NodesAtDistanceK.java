package tree;

public class NodesAtDistanceK {
    private void findInChild(Node root, int k){
        if(root == null)
            return;
        if(k == 0)
            System.out.println(root.getData()+" ");
        findInChild(root.getLeft(), k-1);
        findInChild(root.getRight(),k-1);
    }
    public int printNodes(Node root, int dest, int k){
        if(root == null)
            return -1;
        if(root.getData() == dest){
            findInChild(root, k);
            return k-1;
        }
        int found = printNodes(root.getLeft(), dest,k);
        if(found != -1){
            if(found == 0)
                System.out.println(root.getData()+" ");
            else
                findInChild(root.getRight(), found-1);
            return found-1;
        }
        found = printNodes(root.getRight(), dest, k);
        if(found != -1){
            if(found == 0)
                System.out.println(root.getData()+" ");
            else
                findInChild(root.getRight(),found-1);
            return found-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        NodesAtDistanceK nad = new NodesAtDistanceK();
        BinaryTree bt = new BinaryTree();
        bt.addNode(10);
        bt.addNode(3);
        bt.addNode(-1);
        bt.addNode(8);
        bt.addNode(-6);
        bt.addNode(-11);
        bt.addNode(18);
        bt.addNode(11);
        bt.addNode(13);
        bt.addNode(26);
        bt.addNode(27);
        nad.printNodes(bt.getRoot(), 11, 2);
    }
}
