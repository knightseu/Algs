package lint.ladder3.optional;

/**
 * Created by xuanlin on 2/27/17.
 */
import java.util.ArrayList;
import java.util.Stack;

import common.datastructure.TreeNode;

public class BinaryTreeInorder {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> rst = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            rst.add(cur.val);
            cur = cur.right;
        }
        return rst;
    }
}
