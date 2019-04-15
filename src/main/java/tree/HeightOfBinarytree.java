package tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class HeightOfBinarytree {
    public int heightOfBinaryTree(Node root){
        if(Objects.isNull(root)){
            return 0;
        }
        return maxDepthByRecursive(root);
      //  return maxDepthByIterative(root);
    }

    private int maxDepthByRecursive(Node root){
        if(Objects.isNull(root))
            return 0;
        int  leftMax = maxDepthByRecursive(root.getLeft());
        int rightMax = maxDepthByRecursive(root.getRight());
        return leftMax > rightMax ? (leftMax +1 ): (rightMax +1);
    }

    private int maxDepthByIterative(Node root){
        if(Objects.isNull(root))
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int height = 1;
        while(!q.isEmpty()){
            Node node = q.remove();
            if(Objects.isNull(node)){
                if(q.isEmpty())
                    return height;
                height++;
                q.add(null);
            }else{
                if(node.getLeft() != null)
                    q.add(node.getLeft());
                if(node.getRight() != null)
                    q.add(node.getRight());
            }
        }
        return height;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.addNode(1);
        bt.addNode(2);
        bt.addNode(3);
        bt.addNode(4);
        bt.addNode(5);
        HeightOfBinarytree hbt = new HeightOfBinarytree();
        System.out.println( "Height : "+hbt.heightOfBinaryTree(bt.getRoot()));
    }
}
