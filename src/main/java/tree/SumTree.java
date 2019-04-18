package tree;

class Count {
    int size;
}

public class SumTree {

    //A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present
    // in its left subtree and right subtree

    public boolean isSumTree(Node root) {
        Count count = new Count();
        return isSumTree(root, count);
    }

    private boolean isSumTree(Node root, Count count) {
        if (root == null) {
            return true;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            count.size = root.getData();
            return true;
        }
        Count leftCount = new Count();
        Count rightCount = new Count();
        boolean isLeft = isSumTree(root.getLeft(), leftCount);
        boolean isRight = isSumTree(root.getRight(), rightCount);
        count.size = root.getData() + leftCount.size + rightCount.size;
        return isLeft && isRight && root.getData() == (leftCount.size + rightCount.size);
    }
}
