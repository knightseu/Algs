package lc.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.datastructure.TreeNode;

/**
 * 
 * @author xuanlin
 *
 *
 * notes: return empty list instead of null, thus, reduce code complexity by not checking null for list.addall.
 * 
 */
public class TreeInorderTraversal {
	//recursive
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> rst = new ArrayList<Integer>();
    	if (null != root) {
    		rst.addAll(inorderTraversal(root.left));
            rst.add(root.val);
            rst.addAll(inorderTraversal(root.right));
    	}
        return rst; 
   }
	
	//non-recursive
		public List<Integer> inorderTraversal2(TreeNode root) {
				List<Integer> rst = new ArrayList<Integer>();	
		    	if (null != root) {
		    		Stack<TreeNode> st =  new Stack<TreeNode>();
		    		st.push(root);
		    		while (st.size()>0) {
		    			TreeNode curNode = st.pop();
		    			if ((null == curNode.left) && (null == curNode.right)) {
		    			    rst.add(curNode.val);
		    			} 
		    			else {
		    			    TreeNode leftNode = curNode.left, rightNode = curNode.right;
		    			    curNode.left = null;
		    			    curNode.right = null;
		    			   
		    			    if (null != rightNode) {
		    				    st.push(rightNode);
		        			}	
		    			    st.push(curNode);
		    			    
		    			    if (null != leftNode) {
		    				    st.push(leftNode);
		    				}
		    			}
		    		}
		    	}
		        return rst;
		}
}