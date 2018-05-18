public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        int []res=largestBST(root);
        return res[2];
    }

    public int[] largestBST(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; //the null nodes should have no effect on our calculation
        }
        int[] left = largestBST(root.left);
        int[] right = largestBST(root.right);
        if (root.val > left[1] && root.val < right[0]) { //currrent node along with its children contribute to a valid BST
            return new int[]{Math.min(root.val, left[0]), Math.max(root.val, right[1]), (left[2] + right[2] + 1)};//min,max,size
        } else {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};//current node dosen't contribute to forming a valid BST                                                                     a valid BST,just propagate the highest BST of its children
        }
    }
}
