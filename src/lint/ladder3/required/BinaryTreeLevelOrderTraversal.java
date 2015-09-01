package lint.ladder3.required;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import common.datastructure.TreeNode;

/**
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Have you met this question in a real interview? Yes
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Challenge
Using only 1 queue to implement it.
 * @author xuanlin
 *
 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	
        if (root == null) {
        	return rst;
        }
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        
        while (!que.isEmpty()) {
        	int n = que.size();
        	ArrayList<Integer> curLevel = new ArrayList<Integer>();
        	for (int i = 0; i < n; i++) {
        		TreeNode node = que.poll();
        		curLevel.add(node.val);
        		if (node.left != null) {
        			que.offer(node.left);
        		}
        		if (node.right != null) {
        			que.offer(node.right);
        		}
        	}
        	rst.add(curLevel);
        }
        
        return rst;
    }

}
