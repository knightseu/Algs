package lint.ladder3.optional;

/**
 * Created by xuanlin on 2/27/17.
 */
import java.util.ArrayList;
import common.datastructure.TreeNode;

public class BinaryTreePostorder {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        ArrayList<Integer> left, right;
        if (root.left != null) {
            left = postorderTraversal(root.left);
            if (left != null) {
                rst.addAll(left);
            }
        }
        if (root.right != null) {
            right = postorderTraversal(root.right);
            if (right != null) {
                rst.addAll(right);
            }
        }

        rst.add(root.val);
        return rst;

    }

}
