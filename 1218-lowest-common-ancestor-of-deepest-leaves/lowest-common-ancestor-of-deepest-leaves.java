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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;

        // List<TreeNode> ans = deepestleaf(root);
        List<TreeNode> deepestLeaves = deepestleaf(root);
        TreeNode result = deepestLeaves.get(0);
        for (TreeNode node : deepestLeaves) {
            result = lca(root, result, node);
        }
        return result;
    }
    public TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null) return null;
        if(root.val == n1.val || root.val == n2.val) return root;

        TreeNode l = lca(root.left,n1,n2);
        TreeNode r = lca(root.right,n1,n2);
        if(l != null && r != null) return root;
        if(l != null && r == null) return l;
        if(l == null && r != null) return r;
        return null;
    }
    public List<TreeNode> deepestleaf(TreeNode root){
        List<TreeNode> li = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int n = q.size();
            li = new ArrayList<>();
            for(int i=0; i<n; i++){
                TreeNode rem = q.remove();
                li.add(rem);
                if(rem.left != null){
                    q.add(rem.left);
                }
                if(rem.right != null){
                    q.add(rem.right);
                }
            }
        }
        return li;
    }
}