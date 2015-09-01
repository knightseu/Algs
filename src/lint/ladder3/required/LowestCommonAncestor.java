package lint.ladder3.required;

import common.datastructure.TreeNode;

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Have you met this question in a real interview? Yes
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
 * @author xuanlin
 *
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root ==B) {
        	return root;
        } 
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if (left != null && right != null) {
        	return root;
        }
        
        if (left != null) {
        	return left;
        }
        
        if (right != null) {
        	return right;
        }
        
        return null;
    }
    

}
