package BinaryTree;

public class LowestCommonAncestor {
    //第1题：LowestCommonAncestor3： node A , node B may not exist in Tree;
    class Result{
        // 新建一个类用来表示在递归中表示返回值，其中代表AB是否存在，可能的LCA；
        TreeNode node;
        boolean canFindA;
        boolean canFindB;
        Result(boolean canFindA, boolean canFindB, TreeNode node){
            this.canFindA = canFindA;
            this.canFindB = canFindB;
            this.node = node;
        }
    }//shortcut

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        Result result = helper(root, A, B);
        if(result.canFindA && result.canFindB){
            return result.node;
        }
        return null;
    }

    private Result helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null){
            return new Result(false, false, null);
        }

        Result resultLeft = helper(root.left, A, B);
        Result resultRight = helper(root.right, A, B);

        boolean resultFindA = resultLeft.canFindA || resultRight.canFindA || root == A;
        boolean resultFindB = resultLeft.canFindB || resultRight.canFindB || root == B;

        TreeNode newnode = null;

        if(root == A || root == B){
            newnode = root;
        } else if(resultLeft.node != null && resultRight.node != null){
            newnode = root;
        } else if(resultLeft.node != null){
            newnode = resultLeft.node;
        } else if(resultRight.node != null){
            newnode = resultRight.node;
        }

        return new Result(resultFindA, resultFindB, newnode);
    }

    //第2题：node A, B must exist in Tree;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null || root == A || root == B){
            return root;
        }

        TreeNode left = lowestCommonAncestor1(root.left, A, B);
        TreeNode right = lowestCommonAncestor1(root.right, A, B);

        //当left 和 right 都不为空时，LCA为root；
        if(left != null && right != null){
            return root;
        }
        //当只有左子树为不空时，返回的left 为第一次遇到target node 时的node；
        if(left != null){
            return left;
        }
        //当只有右子树为不空时，返回的right为第一次遇到target node 时的node；
        if(right != null){
            return right;
        }
        return null;
    }
}
