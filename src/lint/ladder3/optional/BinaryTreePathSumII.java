package lint.ladder3.optional;

/**
 * Created by xuanlin on 2/26/17.
 * 246
 * http://www.lintcode.com/en/problem/binary-tree-path-sum-ii/
 */

/*
Related:
http://www.lintcode.com/en/problem/valid-sudoku/
http://www.lintcode.com/en/problem/expression-tree-build/
http://www.lintcode.com/en/problem/count-of-smaller-number-before-itself/
http://www.lintcode.com/en/problem/convert-expression-to-reverse-polish-notation/
http://www.lintcode.com/en/problem/convert-expression-to-polish-notation/

 */
import java.util.List;
import java.util.ArrayList;

import common.datastructure.TreeNode;

public class BinaryTreePathSumII {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        if (root == null)
            return results;
        findSum(root, target, buffer, 0, results);
        return results;
    }

    public void findSum(TreeNode head,
                        int sum,
                        ArrayList<Integer> buffer,
                        int level,
                        List<List<Integer>> results) {
        if (head == null) return;
        int tmp = sum;
        buffer.add(head.val);
        for (int i = level;i >= 0; i--) {
            tmp -= buffer.get(i);
            if (tmp == 0) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int j = i; j <= level; ++j)
                    temp.add(buffer.get(j));
                results.add(temp);
            }
        }
        findSum(head.left, sum, buffer, level + 1, results);
        findSum(head.right, sum, buffer, level + 1, results);
        buffer.remove(buffer.size() - 1);
    }
}


/*
Your are given a binary tree in which each node contains a value. Design an algorithm to get all paths which sum to a given value. The path does not need to start or end at the root or a leaf, but it must go in a straight line down.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

    1
   / \
  2   3
 /   /
4   2
for target = 6, return

[
  [2, 4],
  [1, 3, 2]
]

 */