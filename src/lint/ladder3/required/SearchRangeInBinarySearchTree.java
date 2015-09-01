package lint.ladder3.required;

import java.util.ArrayList;

import common.datastructure.TreeNode;

/**
 * 
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

Have you met this question in a real interview? Yes
Example
If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

    20
   /  \
  8   22
 / \
4   12

 * @author xuanlin
 *
 */
public class SearchRangeInBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    	ArrayList<Integer> rst = new ArrayList<Integer>();
    	helper(root, k1, k2, rst);
    	return rst;
    }
    
    private void helper(TreeNode root, int k1, int k2, ArrayList<Integer> rst) {
    	if (root == null) {
    		return;
    	}
    	
    	if (root.val > k1) {
    		helper(root.left, k1, k2, rst);
    	}
    	if (root.val >= k1 && root.val <= k2) {
    		rst.add(root.val);
    	}
    	if (root.val < k2) {
    		helper(root.right, k1, k2, rst);
    	}
    }

}
