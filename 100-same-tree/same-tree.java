class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // both are null → same
        if (p == null && q == null) {
            return true;
        }

        // one is null, other is not → not same
        if (p == null || q == null) {
            return false;
        }

        // values are different → not same
        if (p.val != q.val) {
            return false;
        }

        // check left and right subtrees
        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
