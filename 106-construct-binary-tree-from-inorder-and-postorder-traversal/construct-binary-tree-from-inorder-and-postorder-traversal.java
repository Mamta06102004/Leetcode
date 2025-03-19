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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int m = postorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildtreehelper(inorder,0,n-1,postorder,0,m-1,map);
    }

    public TreeNode buildtreehelper(int[] in, int is, int ie,
            int[] post, int pos, int poe, HashMap<Integer, Integer> map){
        if(is>ie || pos>poe){
            return null;
        }
        TreeNode root = new TreeNode(post[poe]);

        int idx = map.get(post[poe]);
        int count = idx-is;

        root.left = buildtreehelper(in, is, idx-1, post, pos, pos+count-1,map);
        root.right = buildtreehelper(in, idx+1, ie, post, pos+count, poe-1,map);

        return root;

    }
}