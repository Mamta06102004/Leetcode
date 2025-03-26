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
    int camera;
    public int minCameraCover(TreeNode root) {
        camera = 0;
        int ans = traversal(root);
        if(ans == 0){
            camera++;
        }
        return camera;
    }

    public int traversal(TreeNode root){
        if(root == null){
            return 2;
        }

        int left = traversal(root.left);
        int right = traversal(root.right);
        if(left == 0 || right == 0){
            camera++;
            return 1;
        }
        if(left == 1 || right == 1){
            return 2;
        }

        return 0;
    }
}