package tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathSum {
    public boolean rootToLeafPath(Node root, int sum, List<Node> path){
        if(root == null){
            return false;
        }
        if(root.getLeft() == null && root.getRight() == null){
            if(root.getData() == sum){
                path.add(root);
            return true;
            }
            return false;
        }
        if(rootToLeafPath(root.getLeft(), sum-root.getData(),path)
           || rootToLeafPath(root.getRight(),sum - root.getData(),path)){
            path.add(root);
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        RootToLeafPathSum rtl = new RootToLeafPathSum();
        BinaryTree bt = new BinaryTree();
        bt.addNode(10);
        bt.addNode(15);
        bt.addNode(5);
        bt.addNode(7);
        bt.addNode(19);
        bt.addNode(20);
        bt.addNode(4);
        bt.addNode(3);
        List<Node> result = new ArrayList<>();
        int sum = 22;
        boolean r = rtl.rootToLeafPath(bt.getRoot(), sum, result);
        if(r){
            result.forEach(node -> System.out.print(node.getData() + " "));
        }else{
            System.out.println("No path for sum " + sum);
        }
    }
}
