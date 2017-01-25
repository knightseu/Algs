package lint.ladder3.required;

/**
 * Created by xuan on 1/24/17.
 */
import common.datastructure.TreeNode;

import java.util.*;

public class BTreePath {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> rst = new ArrayList<String>();
        if (null == root) return rst;
        helper(root, "", rst);
        return rst;
    }

    public void helper(TreeNode node, String path, List<String> pathlist) {
        if (path.length() !=0) {
            path += "->";
        }
        path += Integer.toString(node.val);
        if (node.left == null && node.right == null) {

            pathlist.add(path);
        }
        else {
            if (node.left != null){
                helper(node.left, path, pathlist);
            }
            if (node.right != null) {
                helper(node.right, path, pathlist);
            }
        }
    }
}
/*
Given a binary tree, return all root-to-leaf paths.

Have you met this question in a real interview? Yes
Example
Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]

 */