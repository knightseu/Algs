package lint.ladder3.optional;

/**
 * Created by xuanlin on 2/26/17.
 * 474
 * http://www.lintcode.com/en/problem/lowest-common-ancestor-ii/
 */

import common.datastructure.ParentTreeNode;
import common.datastructure.TreeNode;

import java.util.ArrayList;

public class LowestCommonAcestorII {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        if (null == root) {
            return null;
        }
        int hA = getHeight(root, A);
        int hB = getHeight(root, B);
        if (hA == -1 || hB == -1) {
            return null;
        }

        if (hA > hB) {
            for (int i=0; i<hA-hB; i++) {
                A = A.parent;
            }
        }
        else if (hB > hA) {
            for (int i=0; i<hB-hA; i++) {
                B = B.parent;
            }
        }

        while (A !=null && B !=null) {
            if (A == B) {
                return A;
            }
            A = A.parent;
            B = B.parent;
        }

        return null;
    }


    private int getHeight(ParentTreeNode root, ParentTreeNode p) {
        int rst = 0;
        while (p != root && p !=null ) {
            rst++;
            p = p.parent;
        }

        if (p == null) { //p is not in the tree
            return -1;
        }
        return rst;
    }

    //lint code solution helper
    private ArrayList<ParentTreeNode> getPathToRoot(ParentTreeNode root, ParentTreeNode p) {
        ArrayList<ParentTreeNode> rst = new ArrayList<>();
        while (p != root) {
            rst.add(p);
            p = p.parent;
        }
        return rst;
    }
}


/*
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

The node has an extra attribute parent which point to the father of itself. The root's parent is null.

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