package lc.solutions;

import common.datastructure.TreeNode;

public class TreeConstructBinaryTreePreorderInorder {
	//recursive version
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	if ((0 == preorder.length) || (0== inorder.length) || (preorder.length!=inorder.length)) return null;  
        return buildTree(preorder, 0, inorder, 0, preorder.length);
    }
    
    //recursive version
    public static TreeNode buildTree(int[] preorder, int pStart, int[] inorder, int iStart, int length) {
    	if (length <= 0) return null; 
    	if (length == 1) return new TreeNode(preorder[pStart]);
    	
    	//find root position in inorder[]
    	int rIndex=-1;
    	for (int i=0; i<length; i++)
    		if (preorder[pStart] == inorder[i+iStart]) {
    			rIndex = i+iStart;
    			break;
    		}
    	
    	//this should not happen, debug only
    	if (rIndex == -1) {
    		System.out.println("Can not find root in inoder.");
    		return null;
    	}
    	
    	TreeNode root = new TreeNode(preorder[pStart]);
    	int leftLen = rIndex-iStart;
    	int rightLen = length -leftLen -1;
    	root.left = buildTree(preorder, pStart+1, inorder, iStart, leftLen);
    	root.right = buildTree(preorder, pStart+1+leftLen, inorder, rIndex+1, rightLen);
    	return root;
    }
}
