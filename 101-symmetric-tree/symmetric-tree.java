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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        // both null → mirror
        if (left == null && right == null) return true;

        // one null → not mirror
        if (left == null || right == null) return false;

        // values differ → not mirror
        if (left.val != right.val) return false;

        // check cross children
        return isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
    }
}
