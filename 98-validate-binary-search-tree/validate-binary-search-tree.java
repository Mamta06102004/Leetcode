/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isbsthelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isbsthelper(TreeNode root, long min, long max){
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        boolean left = isbsthelper(root.left, min, root.val);
        boolean right = isbsthelper(root.right, root.val, max);

        if(left == false || right == false){
            return false;
        }
        return true;
    }
}