package lc.solutions;

import common.datastructure.TreeNode;

public class TreeSymmetric {
	public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        return areSymmetric(root.left, root.right);
    }
    
    public boolean areSymmetric(TreeNode p, TreeNode q) {
        if (null == p) {
            if (null == q) return true;
            return false;
        }
        if (null == q) return false;
        if (p.val != q.val) return false;
        return areSymmetric(p.left, q.right) & areSymmetric(p.right, q.left);
    }
}
