package lint.ladder3.required;

import java.util.ArrayList;
import java.util.Stack;

import common.datastructure.TreeNode;

/**
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.

Have you met this question in a real interview? Yes
Example
Given binary tree {1,#,2,3}:

1
 \
  2
 /
3
return [1,2,3].

Challenge
Can you do it without recursion?

 * @author xuanlin
 *
 */
public class PreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
        	return rst;
        }
        rst.add(root.val);
        rst.addAll(preorderTraversal(root.left));
        rst.addAll(preorderTraversal(root.right));
        
        return rst;
    }
    
    public ArrayList<Integer> preorderTraversalV2(TreeNode root) {
    	ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
        	return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        
        while (!stack.isEmpty()) {
        	TreeNode cur = stack.pop();
        	rst.add(cur.val);
        	if (cur.right != null) {
        		stack.push(cur.right);
        	}
        	if (cur.left != null) {
        		stack.push(cur.left);
        	}
        }
        
        return rst;
    }

}
