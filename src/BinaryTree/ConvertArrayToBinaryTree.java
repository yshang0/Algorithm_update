package BinaryTree;

public class ConvertArrayToBinaryTree {

        // No.177: Convert Sorted Array to Binary Search Tree With Minimal Height;
        public TreeNode sortedArrayToBST(int[] A) {
            TreeNode root = null;
            int end = A.length - 1;
            int start = 0;
            root = helper(A, start, end);
            return root;
        }
        private TreeNode helper(int[] A, int left, int right){
            TreeNode root = null;
            if(left <= right){
                int mid = (right - left) / 2 + left;
                root = new TreeNode(A[mid]);
                root.left = helper(A, left, mid - 1);
                root.right = helper(A, mid + 1, right);
            }
            return root;
        }
}
