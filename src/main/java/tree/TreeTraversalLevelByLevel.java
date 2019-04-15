package tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeTraversalLevelByLevel {
    public void treeTraversalLevelByLevel(Node root){
        if(root == null){
            System.out.println("tree is empty");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(null);
        q.add(root);
        treeTraversalLevelByLevel(q);
    }
    private void treeTraversalLevelByLevel(Queue<Node> q){
       int level =0;
        while(!q.isEmpty()){
            Node node = q.remove();
            if(Objects.isNull(node)){
                if(!q.isEmpty()){
               //     System.out.println("\nLevel : "+level);
                    System.out.println();
                    q.add(null);
                    level++;
                }
            }else{
                System.out.print(node.getData() +" ");
                if(!Objects.isNull(node.getLeft()))
                    q.add(node.getLeft());
                if(!Objects.isNull(node.getRight()))
                    q.add(node.getRight());
            }
        }
    }

    public static void main(String[] args) {
        TreeTraversalLevelByLevel tt = new TreeTraversalLevelByLevel();
        BinaryTree bt = new BinaryTree();
        bt.addNode(10);
        bt.addNode(20);
        bt.addNode(30);
        bt.addNode(15);
        bt.addNode(-10);
        bt.addNode(0);
        bt.addNode(5);
        bt.addNode(-5);
        bt.addNode(-15);
        bt.addNode(27);
        bt.addNode(35);
        tt.treeTraversalLevelByLevel(bt.getRoot());
    }
}
