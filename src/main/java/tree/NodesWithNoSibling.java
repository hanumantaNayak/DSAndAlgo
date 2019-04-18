package tree;

import java.util.*;

public class NodesWithNoSibling {
    public void printNodes(Node root) {
        if (Objects.isNull(root))
            return;
        if (root.getLeft() == null || root.getRight() == null) {
            if (root.getLeft() != null)
                System.out.println(root.getLeft().getData());
            if (root.getRight() != null)
                System.out.println(root.getRight().getData());
        }
        printNodes(root.getLeft());
        printNodes(root.getRight());
    }
    public void printNodesInIterative(Node root){
        if(Objects.isNull(root))
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node node = q.remove();
            if(Objects.isNull(node)){
                if(q.size() == 1){
                    node = q.peek();
                    System.out.print(node.getData()+" ");
                }
                if(!q.isEmpty())
                    q.add(null);
            }else {
             if(node.getLeft() != null)
                 q.add(node.getLeft());
             if(node.getRight() != null)
                 q.add(node.getRight());
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.addNode(10);
        bt.addNode(5);
        bt.addNode(-1);
        bt.addNode(-5);
        bt.addNode(20);
        bt.addNode(25);
        NodesWithNoSibling nws = new NodesWithNoSibling();
       // nws.printNodes(bt.getRoot());
        nws.printNodesInIterative(bt.getRoot());
    }
}