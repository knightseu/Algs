package lint.ladder3.required;

import java.util.Stack;

import common.datastructure.TreeNode;

/**
 * Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.
Have you met this question in a real interview? Yes
Example
For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
1      11
 \       \
  6       12
Challenge
Extra memory usage O(h), h is the height of the tree.

 * @author xuanlin
 *
 */
public class BinarySearchTreeIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Stack<TreeNode> stack;
	private TreeNode curNode;
    //@param root: The root of binary tree.
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        curNode = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        if (curNode != null || !stack.isEmpty()) {
        	return true;
        }
        return false;
    }
    
    //@return: return next node
    public TreeNode next() {
        while (curNode != null) {
        	stack.push(curNode);
        	curNode = curNode.left;
        }
        
        TreeNode rst = stack.top();
        curNode = rst.right;
        return rst;
    }

}
