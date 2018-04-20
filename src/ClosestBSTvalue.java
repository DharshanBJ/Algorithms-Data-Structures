public class ClosestBSTvalue {

        public int closestValue(TreeNode root, double target) {
            if(root.val==target)return root.val;

            TreeNode kid=root.val>target? root.left:root.right;
            if(kid==null)return root.val;

            int b=closestValue(kid,target);
            return Math.abs(root.val - target)<Math.abs(b-target)? root.val:b;
        }
    }
}
