package lc.solutions;

import common.datastructure.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p) {
            if (null == q) return true;
            return false;
        }
        if (null == q) return false;
        if (p.val == q.val) return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
        return false;
    }
}
