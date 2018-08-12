package BinaryTree;
import java.util.ArrayList;
import java.util.List;

public class Paths {
    //No.480: Binary Tree Paths; 画出每一个path。
    //Given a binary tree, return all root-to-leaf paths.
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(root.left == null && root.right == null){
            result.add("" + root.val);
            return result;
        }
        List<String> leftpath = binaryTreePaths(root.left);
        List<String> rightpath = binaryTreePaths(root.right);

        for(String path : leftpath){
            result.add(root.val + "->" + path);
        }
        for(String path : rightpath){
            result.add(root.val + "->" + path);
        }
        return result;
    }
}
