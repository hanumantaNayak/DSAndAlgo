package tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SizeOfBinaryTree {
    public int sizeOfBinaryTree(Node root){
        if(Objects.isNull(root)) {
            return 0;
        }
       // return sizeOnIterative(root);
        return sizeOnRecurssive(root);
    }
    //T(n) : O(n)
    //S(n) : O(max_level)
    private int sizeOnRecurssive(Node root){
        if(Objects.isNull(root))
            return 0;
        return sizeOnRecurssive(root.getLeft()) + sizeOnRecurssive(root.getRight())+1;
    }
    //T(n) : O(n)
    //S(n) : O(max_level)
    private int sizeOnIterative(Node root) {
        if (Objects.isNull(root))
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while (!q.isEmpty()) {
            Node node = q.remove();
            count++;
            if (node.getLeft() != null)
                q.add(node.getLeft());
            if (node.getRight() != null)
                q.add(node.getRight());
        }
        return count;
    }

    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        bt.addNode(60);
        bt.addNode(90);
        bt.addNode(70);
        bt.addNode(75);
        bt.addNode(100);
        bt.addNode(40);
        bt.addNode(50);
        bt.addNode(20);
        SizeOfBinaryTree sizeOfBinaryTree = new SizeOfBinaryTree();
        System.out.println(sizeOfBinaryTree.sizeOfBinaryTree(bt.getRoot()));
    }
}
