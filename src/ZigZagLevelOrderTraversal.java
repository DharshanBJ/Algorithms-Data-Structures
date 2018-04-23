import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean zigzag=false;
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null)return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            List<Integer>lst=new ArrayList<>();
            for(int i=0;i<count;i++){
                TreeNode node=queue.poll();

                if(zigzag){
                    lst.add(0,node.val); //add nodes in reverse order to a Linked List
                }else{
                    lst.add(node.val);
                }
                if(node.left !=null){
                    queue.add(node.left);

                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(lst);
            zigzag=!zigzag; //toggle the zigzag variable
        }
        return res;
    }
}
