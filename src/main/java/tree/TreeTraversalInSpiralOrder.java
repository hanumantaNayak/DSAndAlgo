package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class TreeTraversalInSpiralOrder {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.addNode(10);
        bt.addNode(30);
        bt.addNode(25);
        bt.addNode(35);
        bt.addNode(-10);
        bt.addNode(0);
        bt.addNode(-20);
        bt.addNode(-15);
        bt.addNode(45);
        System.out.println("Level order traversal");
        TreeTraversalLevelByLevel levelByLevel = new TreeTraversalLevelByLevel();
        levelByLevel.treeTraversalLevelByLevel(bt.getRoot());
        System.out.println("\nSpiral order traversal");
        TreeTraversalInSpiralOrder spiralOrder = new TreeTraversalInSpiralOrder();
        spiralOrder.treeTraversalInSpiralOrder(bt.getRoot());
    }

    public void treeTraversalInSpiralOrder(Node root) {
        if (Objects.isNull(root)) {
            System.out.println("Tree is null or empty!");
            return;
        }
        Deque<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        treeTraversalInSpiralOrder(q);

    }

    private void treeTraversalInSpiralOrder(Deque<Node> q) {
        boolean flip = true;
        while (!Objects.isNull(q) && !q.isEmpty()) {
            Node node = flip ? q.pollFirst() : q.pollLast();
            if (Objects.isNull(node)) {
                if (!q.isEmpty()) {
                    if (flip)
                        q.addFirst(null);
                    else
                        q.addLast(null);
                }
                flip = !flip;
            } else {
                System.out.print(node.getData() + " ");
                if (flip) {
                    if (!Objects.isNull(node.getRight()))
                        q.addLast(node.getRight());
                    if (!Objects.isNull(node.getLeft()))
                        q.addLast(node.getLeft());
                } else {
                    if (!Objects.isNull(node.getLeft()))
                        q.addFirst(node.getLeft());
                    if (!Objects.isNull(node.getRight()))
                        q.addFirst(node.getRight());
                }
            }
        }
    }
}
