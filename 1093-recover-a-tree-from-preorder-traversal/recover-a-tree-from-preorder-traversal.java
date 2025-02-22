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
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.isEmpty()) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        int i = 0;

        while (i < traversal.length()) {
            int depth = 0;

            // Count dashes to determine depth
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Extract the node value
            int value = 0;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            // Create the node
            TreeNode node = new TreeNode(value);

            // Adjust stack to match depth
            while (stack.size() > depth) {
                stack.pop();
            }

            // Assign as left or right child
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            // Push current node to stack
            stack.push(node);
        }

        // Root is the last node remaining in the stack after pops
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
    
}