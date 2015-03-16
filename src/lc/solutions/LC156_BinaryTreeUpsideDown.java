package lc.solutions;

import common.datastructure.TreeNode;
/*
 *  Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
 *  flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
For example:
Given a binary tree {1,2,3,4,5},

    1
   / \
  2   3
 / \
4   5

return the root of the binary tree [4,5,2,#,#,3,1].

   4
  / \
 5   2
    / \
   3   1  

 */

public class LC156_BinaryTreeUpsideDown {
	
	/*
	 *  1. 对于一个parent来说，加入有right node，必须得有left node。而有left node，right node可以为空。而right node必须为叶子节点。
	 *  所以该树每层至多有2个节点，并且2节点有共同的parent。
	 *  
	 *  2. 所以对于最底层来说，必有一个left node，而这个left node则为整个新树的根 —— 例子中的4为最底层的左节点，最后成为新树的root。
	 *  
	 *  3. 原树的根节点，变为了新树的最右节点。
	 *  
	 *  4. 对于子树1 2 3来说，需要在以2为根的子树2 4 5建立成新树4 5 2后，插入到新树的最右节点2下面。原树的根节点root为left child，原树root->right为新树的left nnode
	 */

	public TreeNode UpsideDownBinaryTree(TreeNode root) {
        TreeNode p = root, parent = null, parentRight = null;
        while (p!=null) {
            TreeNode left = p.left;
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;
            parent = p;
            p = left;
        }
        return parent;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
