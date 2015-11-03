package lint.ladder3.optional;

import java.util.LinkedList;
import java.util.Queue;

import common.datastructure.TreeNode;

public class SerializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(20);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(12);
		TreeNode n5 = new TreeNode(10);
		TreeNode n6 = new TreeNode(14);
		n1.left = n2;
		n2.left = n3;
		n2.right = n4;
		n4.left = n5;
		n4.right = n6;
		
		System.out.println(serialize(n1));
	}
	
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
        
        return serializeHelper(root);
        
    }
    private static String serializeHelper(TreeNode root) {
    	StringBuilder rst = new StringBuilder();
    	if (root == null) {
    	    rst.append("#");
    	} else {
    		rst.append(root.val);
    		//String s = rst.toString(); 
    		rst.append(serializeHelper(root.left));
    		//s = rst.toString();
    		
    		rst.append(serializeHelper(root.right));
    	}
    	return rst.toString();
    }
    
    /*
     * Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        	int n = queue.size();
        	for (int i = 0; i < n; i++) {
        		TreeNode cur = queue.poll();
        		if (cur == null) {
        			sb.append("#");
        		} else {
        			sb.append(cur.val);
        			queue.offer(cur.left);
        			queue.offer(cur.right);
        		}
        	}
        }
     */
 
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
    	if (data != null && data.length() >0 ){
    		TreeNode cur;
    		if (data.charAt(0) == '#') {
    			cur = null;
    		} else {
    			cur = new TreeNode(Integer.parseInt(data.substring(0, 1)));
    		}
    		
    	}
        return null;
    }

}
