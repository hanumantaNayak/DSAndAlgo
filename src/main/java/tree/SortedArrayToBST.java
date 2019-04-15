package tree;

import java.util.Objects;

public class SortedArrayToBST {
    public Node SortedArrayToBST(int[] nums){
        if(Objects.isNull(nums) || nums.length == 0 )
            return null;
        return toBST(nums, 0 , nums.length-1);
    }
    private Node toBST(int[] nums, int low, int high){
        if(low > high)
            return null;
        int mid = (low+high)/2;
        Node node = new Node(nums[mid]);
        node.setLeft(toBST(nums, low, mid-1));
        node.setRight(toBST(nums,mid+1, high));
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        SortedArrayToBST arrayToBST = new SortedArrayToBST();
        Node root = arrayToBST.SortedArrayToBST(nums);
//        BinaryTree bt = new BinaryTree();
//        bt.setRoot(root);
        TreeTraversalLevelByLevel levelByLevel = new TreeTraversalLevelByLevel();
        levelByLevel.treeTraversalLevelByLevel(root);
    }
}
