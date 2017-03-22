package common.datastructure;

/**
 * Created by xuanlin on 3/12/17.
 */
public class Tree {
    /**
     *
     * @return root a BST
     *
     *         5
     *   4          10
     * 3       6         15
     *           7    13    20
     *              12 14  18 30
     */
    TreeNode genSampleTree() {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(10);
        root.left = a;
        root.right =b;

        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(10);
        return root;
    }
}
