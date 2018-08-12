package MethodCreate;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    //is it a constructor?
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    //True if there has next node, or false
    public boolean hasNext() {
        return (!stack.isEmpty());
    }
    //return next node
    public TreeNode next() {
        TreeNode curt = stack.pop();
        TreeNode node = curt;

        if(node.right == null){
            return curt;
        } else {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return curt;
        }
    }
}
