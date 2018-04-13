
 // Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class ConstructBinaryTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static TreeNode helper(int[]preorder,int prestart,int preend,int[]inorder,int instart,int inend){
        if(prestart>preend || instart>inend)return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int inIndex=instart;
        for(int i=instart;i<=inend;i++){
            if(inorder[i]==preorder[prestart]){
                inIndex=i;
            }
        }
        int leftsubtreeLength=inIndex-instart;
        root.left=helper(preorder,prestart+1,prestart+leftsubtreeLength,inorder,instart,inIndex-1);
        root.right=helper(preorder,prestart+leftsubtreeLength+1,preend,inorder,inIndex+1,inend);
        return root;
    }

    public static void main(String[] args){
        int[] preorder=new int[]{3,9,20,15,7};
        int[] inorder=new int[]{9,3,15,20,7};
        TreeNode root=buildTree(preorder,inorder);
        System.out.println("Root of the constructed Binary tree is "+root.val);
    }
}
