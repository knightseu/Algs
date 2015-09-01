package lint.ladder3.required;

import common.datastructure.TreeNode;

/**
 * 
 * Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.

Have you met this question in a real interview? Yes
Example
Given binary search tree as follow, after Insert node 6, the tree should be:

  2             2
 / \           / \
1   4   -->   1   4
   /             / \ 
  3             3   6
Challenge
Can you do it without recursion?

 * @author xuanlin
 *
 */
public class InsertNodeInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
        	return node;
        }
        if (node.val < root.val) {
        	root.left = insertNode(root.left, node);
        } else {
        	root.right = insertNode(root.right, node);
        }
        return root;
    }
    
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNodeV2(TreeNode root, TreeNode node) {
        if (root == null) {
        	return node;
        }
        TreeNode p = null, cur = root;
        
        while (cur != null)  {
        	p = cur;
        	cur = cur.val > node.val ?
        		  cur.left : cur.right;
        }
        
        if (p != null) {
            if (p.val >  node.val) {
        	    p.left = node;
            } else {
        	    p.right = node;
            }
        }
        
        return root;
    }

}
