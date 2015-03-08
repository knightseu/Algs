package lc.solutions;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

import common.datastructure.TreeNode;
/**
 * 
 * @author xuanlin
 *
 *
 * Notes: change order each level
 * 
 */
public class TreeZigzagLevelTraversal {
	//public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      //  List<List<Integer>> rst = new ArrayList<List<Integer>>();
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (null != root) { 
            Stack<TreeNode> curLevel = new Stack<TreeNode>();
            Stack<TreeNode> nextLevel = new Stack<TreeNode>();
            Stack<TreeNode> tmp=null;
            boolean bLeftToRight = true;
            curLevel.add(root);
            
            while (!curLevel.isEmpty()) {
            	ArrayList<Integer> curLevelVals = new ArrayList<Integer>();
            	while (!curLevel.isEmpty()) {
            		TreeNode curNode = curLevel.pop();
            		curLevelVals.add(curNode.val);
            		if (bLeftToRight) {
            		    if (null != curNode.left)
            		        nextLevel.push(curNode.left);
            		    if (null != curNode.right)
            		        nextLevel.push(curNode.right);
            		} else {
            		    if (null != curNode.right)
            		        nextLevel.push(curNode.right);
            		    if (null != curNode.left)
            		        nextLevel.push(curNode.left);
            		}
            	}
            	rst.add(curLevelVals);
            	bLeftToRight = !bLeftToRight;
            	tmp = curLevel;
            	curLevel = nextLevel;
            	nextLevel = tmp;
            }
        }
        return rst;
    }
}
