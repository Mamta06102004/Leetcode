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
    public void flatten(TreeNode root) {
        flattenBT(root);
    }

    public TreeNode flattenBT(TreeNode root){
        if(root == null) return null;

        TreeNode lt = flattenBT(root.left);
        TreeNode rt = flattenBT(root.right);

        if(lt == null && rt == null){
            return root;
        }
        else if(lt == null && rt != null){
            return rt;
        }
        else if(lt != null && rt == null){
            TreeNode lchild = root.left;
            root.right = lchild;
            root.left = null;
            return lt;
        }
        else{               //lt != null && rt != null
            TreeNode lchild = root.left;
            TreeNode rchild = root.right;
            root.left = null;
            root.right = lchild;
            lt.right = rchild;
            return rt;
        }
    }
}