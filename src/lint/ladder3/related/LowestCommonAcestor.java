package lint.ladder3.related;

/**
 * Created by xuanlin on 2/26/17.
 * 88
 * http://www.lintcode.com/en/problem/lowest-common-ancestor/
 */
import common.datastructure.TreeNode;

public class LowestCommonAcestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A     and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (null == root || root == A || root == B) {
            return root;
        }

        //divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        //conquer
        if (left != null && right !=null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right !=null) {
            return right;
        }
        return null;
    }


    private boolean cover(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }

        if (root == p) {
            return true;
        }

        return cover(root.left, p) || cover(root.right, p);
    }
}

/*
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

 Notice

Assume two nodes are exist in tree.

Have you met this question in a real interview? Yes
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
 */