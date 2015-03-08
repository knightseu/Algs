package lc.solutions;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import common.datastructure.TreeNode;


public class TreeBinaryTreeLevelOrderTraversal {
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
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
            	rst.add(curLevelVals);
            	
            	for (TreeNode treenode: curLevelNodes) {
            		if (null != treenode.left) queue.add(treenode.left);
            		if (null != treenode.right) queue.add(treenode.right);

            	}
            }
        }
        return rst;
    }
    
    /*
    //List<List<Integer>>  is not compiled in local eclipse, might be due to different version of java
    public List<List<Integer>> levelOrderAccepted(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
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
            	rst.add(curLevelVals);
            	
            	for (TreeNode treenode: curLevelNodes) {
            		if (null != treenode.left) queue.add(treenode.left);
            		if (null != treenode.right) queue.add(treenode.right);
            	}
            }
        }
        return rst;
    }*/
}
