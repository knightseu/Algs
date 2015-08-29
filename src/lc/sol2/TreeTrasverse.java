package lc.sol2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import common.datastructure.TreeNode;
public class TreeTrasverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void postOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Map<TreeNode, Integer> visited = new HashMap<TreeNode, Integer>();
		
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				TreeNode t = stack.pop();
				if (visited.containsKey(t)) { //second time
					System.out.println(t.val);
					p = null;
				} else {//first time
					visited.put(t, 1);
					p = t.right;
				}
			}
		}
	}

}
