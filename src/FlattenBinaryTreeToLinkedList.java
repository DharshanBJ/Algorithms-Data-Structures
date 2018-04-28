public class FlattenBinaryTreeToLinkedList {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        helper(root);
    }
    public void helper(TreeNode root){
        if(root==null)return;
        helper(root.right);
        helper(root.left);
        root.left=null;
        root.right=prev;
        prev=root;
    }
}
