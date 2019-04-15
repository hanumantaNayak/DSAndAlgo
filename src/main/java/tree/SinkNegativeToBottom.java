package tree;

import java.util.Objects;

public class SinkNegativeToBottom {
    public void sinkNegativeToBootom(Node root) {
        if (Objects.isNull(root))
            return;
        sinkNegativeToBootom(root.getLeft());
        sinkNegativeToBootom(root.getRight());
        if (root.getData() < 0)
            pushDown(root);
    }

    private void pushDown(Node root) {
        if (Objects.isNull(root))
            return;
        // already leaf node. nothing to do. just return
        if (root.getLeft() == null && root.getRight() == null)
            return;
        if (root.getLeft() != null && root.getLeft().getData() >= 0) {
            int temp = root.getData();
            root.setData(root.getLeft().getData());
            root.getLeft().setData(temp);
            pushDown(root.getLeft());
        } else if (root.getRight() != null && root.getRight().getData() >= 0) {
            int temp = root.getData();
            root.setData(root.getRight().getData());
            root.getRight().setData(temp);
            pushDown(root.getRight());
        }
    }

    public static void main(String[] args) {
        int[] preorder = {-1, 1, 6, -2, 11, 3, 2, -3, 31, 22, 17};
        int[] inorder = {-2, 6, 11, 1, 3, -1, 31, -3, 22, 2, 17};
        //TODO create binary tree for number given in in-order  and pre-order list
        BinaryTree bt = new BinaryTree();
        bt.addNode(-10);
        bt.addNode(-5);
        bt.addNode(-20);
        bt.addNode(30);
        bt.addNode(10);
        bt.addNode(50);
        System.out.println("Before sinking negative numbers");
        TreeTraversalLevelByLevel levelByLevel = new TreeTraversalLevelByLevel();
        levelByLevel.treeTraversalLevelByLevel(bt.getRoot());
        System.out.println("\n\nAfter sinking negative numbers");
        SinkNegativeToBottom negativeToBottom = new SinkNegativeToBottom();
        negativeToBottom.sinkNegativeToBootom(bt.getRoot());
        levelByLevel.treeTraversalLevelByLevel(bt.getRoot());
    }
}
