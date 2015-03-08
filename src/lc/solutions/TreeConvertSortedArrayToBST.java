package lc.solutions;

import common.datastructure.TreeNode;

public class TreeConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        return buildFromSortedArray(num, 0, num.length-1);
    }
    public TreeNode buildFromSortedArray(int[] num, int start, int end) {
    	if (start>end) return null;
    	if (start == end) return new TreeNode(num[start]);
    	int middle = (start+end)/2;
    	TreeNode root = new TreeNode(num[middle]);
    	root.left =  buildFromSortedArray(num, start, middle-1);
    	root.right =  buildFromSortedArray(num, middle+1, end);
    	return root;
    }
}
