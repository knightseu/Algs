package lc.solutions;

import common.datastructure.TreeNode;

/**
 * 
 * @author xuanlin
 *
 *
 * notes: need to take care of Integer.MIN_VALUE, Integer.MAX_VALUE
 * 
 */
public class TreeValidateBST {
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }	
    
    public boolean isValidBST(TreeNode root, int min, int max) {
        if (null == root) return true;
        if ((root.val < min) || (root.val > max)) return false;
        
        if (root.val == Integer.MIN_VALUE) {
            if (null != root.left) return false;
            return isValidBST(root.right,root.val+1, max);
        } else if (root.val == Integer.MAX_VALUE) {
            if (null != root.right) return false;
            return isValidBST(root.left, min, root.val-1);
        } else {
            return    isValidBST(root.left, min, root.val-1) &&
             isValidBST(root.right,root.val+1, max);
        }
    }
}
