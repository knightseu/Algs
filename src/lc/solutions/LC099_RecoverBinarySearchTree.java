package lc.solutions;

import common.datastructure.TreeNode;

/*
 *  Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

 */
public class LC099_RecoverBinarySearchTree {
	/*
	 * 解决方法是利用中序遍历找顺序不对的两个点，最后swap一下就好。

 因为这中间的错误是两个点进行了交换，所以就是大的跑前面来了，小的跑后面去了。

 所以在中序便利时，遇见的第一个顺序为抵减的两个node，大的那个肯定就是要被recovery的其中之一，要记录。

 另外一个，要遍历完整棵树，记录最后一个逆序的node。

 简单而言，第一个逆序点要记录，最后一个逆序点要记录，最后swap一下。

 因为Inorder用了递归来解决，所以为了能存储这两个逆序点，这里用了全局变量，用其他引用型遍历解决也可以。
	 */
	private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE); 
    
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (firstElement == null && root.val < lastElement.val) {
            firstElement = lastElement;
        }
        if (firstElement != null && root.val < lastElement.val) {
            secondElement = root;
        }
        lastElement = root;
        traverse(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        // traverse and get two elements
        traverse(root);
        // swap
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
