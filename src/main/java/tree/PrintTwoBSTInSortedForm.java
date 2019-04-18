package tree;

import java.util.Deque;
import java.util.LinkedList;

public class PrintTwoBSTInSortedForm {
    public void printInSortedOrder(Node root1, Node root2) {
        Deque<Node> q1 = new LinkedList<>();
        Deque<Node> q2 = new LinkedList<>();
        while (true) {
            if (root1 != null) {
                q1.addFirst(root1);
                root1 = root1.getLeft();
                continue;
            }
            if (root2 != null) {
                q2.addFirst(root2);
                root2 = root2.getLeft();
                continue;
            }
            if (!q1.isEmpty())
                root1 = q1.peekFirst();
            if (!q2.isEmpty())
                root2 = q2.peekFirst();

            if (root1 != null && root2 != null) {
                if (root1.getData() < root2.getData()) {
                    System.out.print(root1.getData() + " ");
                    root1 = q1.pollFirst();
                    root1 = root1.getRight();
                    root2 = null;
                } else {
                    System.out.print(root2.getData() + " ");
                    root2 = q2.pollFirst();
                    root2 = root2.getRight();
                    root1 = null;
                }
            } else if (root1 != null) {
                System.out.print(root1.getData() + " ");
                root1 = q1.pollFirst();
                root1 = root1.getRight();
            } else if (root2 != null) {
                System.out.print(root2.getData() + " ");
                root2 = q2.pollFirst();
                root2 = root2.getRight();
            }
            if (root1 == null && root2 == null && q1.isEmpty() && q2.isEmpty())
                break;
        }
    }

    public static void main(String[] args) {
        PrintTwoBSTInSortedForm ptb = new PrintTwoBSTInSortedForm();
        BinaryTree bt = new BinaryTree();
        bt.addNode(10);
        bt.addNode(15);
        bt.addNode(5);
        bt.addNode(7);
        bt.addNode(19);
        bt.addNode(20);
        bt.addNode(-1);
        BinaryTree bt2 = new BinaryTree();
        bt2.addNode(-4);
        bt2.addNode(-3);
        bt2.addNode(6);
        bt2.addNode(11);
        bt2.addNode(22);
        bt2.addNode(26);
        TreeTraversalLevelByLevel lvl = new TreeTraversalLevelByLevel();
        System.out.println("\n\nTree 1");
        lvl.treeTraversalLevelByLevel(bt.getRoot());
        System.out.println("\n\nTree 2");
        lvl.treeTraversalLevelByLevel(bt2.getRoot());
        System.out.println("\nSorted order");
        ptb.printInSortedOrder(bt.getRoot(), bt2.getRoot());
    }
}
