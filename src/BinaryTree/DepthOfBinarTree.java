package BinaryTree;

public class DepthOfBinarTree {
        //No.155: Minimum Depth of Binary Tree
        public int minDepth(TreeNode root) {
            // write your code here
            int dep = 0;
            if(root == null){
                return dep;
            }
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if(left == 0 && right == 0){
                dep = 1;
            } else if(left == 0 || right == 0){
                dep = Math.max(left, right) + 1;
            } else {
                dep = Math.min(left, right) + 1;
            }
            return dep;
        }
}
