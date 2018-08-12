package BinaryTree;
import java.util.ArrayList;
import java.util.List;

public class PathSum {
        // 第1题：求最大的Path Sum, start and end can be any node of tree;
        class Result{
            int single;
            int max;
            Result(int single, int max){
                this.single = single;
                this.max = max;
            }
        }
        public int maxPathSum(TreeNode root) {
            // write your code here
            Result result = helper(root);
            return result.max;
        }
        private Result helper(TreeNode root){
            if(root == null){
                return new Result(0, Integer.MIN_VALUE);
            }

            Result resultleft = helper(root.left);
            Result resultright = helper(root.right);

            int single = root.val + Math.max(Math.max(resultleft.single, resultright.single), 0);

            int max = Math.max(resultleft.max, resultright.max);
            int maxIncRoot = root.val + Math.max(resultleft.single, 0) + Math.max(resultright.single, 0);

            max = Math.max(maxIncRoot, max);

            return new Result(single, max);
        }

        //第2题：The path start at root, but may end at any node in the tree, and contain at least one node in it.
        int max_sum = Integer.MIN_VALUE;

        public int maxPathSum2(TreeNode root) {
            return maxPathSum3(root, 0);
        }

        private int maxPathSum3(TreeNode root, int cur_sum){
            // write your code here
            if(root == null){
                return 0;
            }
            cur_sum = cur_sum + root.val;
            if (cur_sum > max_sum){
                max_sum = cur_sum;
                //
            }
            // max_sum = Math.max(max_sum, cur_sum);
            maxPathSum3(root.right, cur_sum);
            maxPathSum3(root.left, cur_sum);

            return max_sum;
        }

        //No.376 :Binary Tree Path Sum; TARGET
        //Given a binary tree, find all paths that sum of the nodes in the path equals to a given number TARGET.
        //A valid path is from root node to any of the leaf nodes.
        public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
            // write your code here
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            findSum(root, target, result, path);
            return result;
        }

        private void findSum(TreeNode root, int target, List<List<Integer>> result, List<Integer> path){
            if(root == null){
                return;
            }

            path.add(root.val);
            target = target - root.val;
            if(root.left == null && root.right == null && target == 0){
                result.add(new ArrayList<>(path));
            }
            findSum(root.left, target, result, path);
            findSum(root.right, target, result, path);
            path.remove(path.size()-1);
        }
}
