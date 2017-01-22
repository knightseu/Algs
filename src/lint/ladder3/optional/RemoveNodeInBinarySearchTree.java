package lint.ladder3.optional;

import common.datastructure.TreeNode;

/**
 * Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.

Have you met this question in a real interview? Yes
Example
Given binary search tree:

          5

       /    \

    3          6

 /    \

2       4

Remove 3, you can either return:

          5

       /    \

    2          6

      \

         4

or :

          5

       /    \

    4          6

 /   

2

 * @author xuanlin
 *
 */
public class RemoveNodeInBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
    	
    	TreeNode dummy = new TreeNode(0);
    	dummy.left = root;
    	
    	TreeNode parent = findNode(dummy, root, value);
    	TreeNode node;
    	if (parent != null && parent.left.val == value) {
    		node = parent.left;
    	} else if (parent !=null && parent.right.val == value) {
    		node = parent.right;
    	} else {
    		return dummy.left;
    	}
    	//1. The node does not have child
    	//2. The node have only left child
    	//3. The node have only right child
    	//4. The node have both left and right child.
		return null;
    }
    
    /**
     * 
     * @param parent Parent Node
     * @param node Current Node
     * @param value The value of the node we are looking for.
     * 
     * @return
     */
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
    	if (node == null) {
    		return parent;
    	}
    	
    	if (node.val == value) {
    		return parent;
    	} else if (node.val > value) {
    		return findNode(node, node.left, value);
    	} else {
    		return findNode(node, node.right, value);
    	}
    }

}
