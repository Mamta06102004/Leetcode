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
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteinbst(root, key);
    }
    public TreeNode deleteinbst(TreeNode root, int k){
        if(root == null) return null;
        if(root.val > k){
            root.left = deleteinbst(root.left,k);
        }
        else if(root.val < k){
            root.right = deleteinbst(root.right,k);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left != null && root.right == null){
                return root.left;
            }
            else if(root.left == null && root.right != null){
                return root.right;
            }
            else{
                int max = maxfind(root.left);
                root.val = max;
                root.left = deleteinbst(root.left, max);
                return root;
            }
        }
        return root;
    }
    public int maxfind(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
}