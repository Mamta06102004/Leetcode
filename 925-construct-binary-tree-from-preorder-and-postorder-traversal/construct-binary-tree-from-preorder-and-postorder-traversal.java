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
    private int preIndex = 0;
    private Map<Integer, Integer> postIndexMap;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return buildTree(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if (preIndex >= preorder.length || postStart > postEnd) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (postStart == postEnd) return root;

        int leftSubtreeIndex = postIndexMap.get(preorder[preIndex]);

        root.left = buildTree(preorder, postorder, postStart, leftSubtreeIndex);
        root.right = buildTree(preorder, postorder, leftSubtreeIndex + 1, postEnd - 1);

        return root;
    }    
    
}