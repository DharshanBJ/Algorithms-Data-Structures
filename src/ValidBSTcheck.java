import javax.swing.tree.TreeNode;

public class ValidBSTcheck {

    public boolean isValidBST(TreeNode root) {
        return ValidBST(root,null,null);
    }
    public boolean ValidBST(TreeNode root, Integer max, Integer min){
        if(root==null)return true;
        if(min != null && root.val <= min)return false;
        if(max != null && root.val >= max)return false;
        return ValidBST(root.left,root.val,min) && ValidBST(root.right,max,root.val);
    }
}

