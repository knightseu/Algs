package lc.solutions;

import common.datastructure.TreeNode;

public class TreeConstructBinaryTreeInorderPostorder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
    	if ((0 == postorder.length) || (0== inorder.length) || (postorder.length!=inorder.length)) return null;  
        return buildTree(postorder, 0, inorder, 0, postorder.length);
    }
    
    //recursive version
    public static TreeNode buildTree(int[] postorder, int pStart, int[] inorder, int iStart, int length) {
    	if (length <= 0) return null; 
    	if (length == 1) return new TreeNode(postorder[pStart+length-1]);
    	
    	//find root position in inorder[]
    	int rIndex=-1;
    	for (int i=0; i<length; i++)
    		if (postorder[pStart+length-1] == inorder[i+iStart]) {
    			rIndex = i+iStart;
    			break;
    		}
    	
    	//this should not happen, debug only
    	if (rIndex == -1) {
    		System.out.println("Can not find root in inoder.");
    		return null;
    	}
    	
    	TreeNode root = new TreeNode(inorder[rIndex]);
    	int leftLen = rIndex-iStart;
    	int rightLen = length -leftLen -1;
    	root.left = buildTree(postorder, pStart, inorder, iStart, leftLen);
    	root.right = buildTree(postorder, pStart+leftLen, inorder, rIndex+1, rightLen);
    	return root;
    }
}
