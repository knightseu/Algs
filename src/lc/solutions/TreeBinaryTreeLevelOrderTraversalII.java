package lc.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import common.datastructure.TreeNode;

public class TreeBinaryTreeLevelOrderTraversalII {
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        Stack<ArrayList<Integer>> st = new Stack<ArrayList<Integer>>();
        if (null != root) { 
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
            	ArrayList<TreeNode> curLevelNodes = new ArrayList<TreeNode> ();
            	ArrayList<Integer> curLevelVals = new ArrayList<Integer>();
            	while (!queue.isEmpty()) {
            		TreeNode curNode = queue.remove();
            		curLevelNodes.add(curNode);
            		curLevelVals.add(curNode.val);
            	}
            	st.push(curLevelVals);
            	
            	for (TreeNode treenode: curLevelNodes) {
            		if (null != treenode.left) queue.add(treenode.left);
            		if (null != treenode.right) queue.add(treenode.right);

            	}
            }
        }
        while (!st.empty())
            rst.add(st.pop());
        return rst;
    }
}
