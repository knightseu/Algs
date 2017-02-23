package salesforce;

import common.datastructure.TreeNode;
import java.util.LinkedList;
/**
 * Created by xuanlin on 2/21/17.
 */
public class TreePathLeafToRoot {
    static void printPath(TreeNode root) {
        if (null == root) {
            return;
        }
        LinkedList<TreeNode> path = new LinkedList<>();
        helper(root, path);
    }

    static void helper(TreeNode root, LinkedList<TreeNode> path) {
        path.add(root);
        if (null == root.left && null == root.right) {
            //root is leaf;
            for (int i=path.size()-1; i>=0; i--) {
                System.out.print(path.get(i).val);
            }
            System.out.println();
        }
        if (null !=root.left) {
            helper(root.left, path);
            path.removeLast();
        }
        if (null != root.right) {
            helper(root.right, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        //         50
        //     40      70
        //  30   45
        TreeNode a = new TreeNode(50);
        TreeNode b = new TreeNode(40);
        TreeNode c = new TreeNode(70);
        a.left = b;
        a.right = c;
        TreeNode d = new TreeNode(30);
        TreeNode e = new TreeNode(45);
        b.left = d;
        b.right = e;

        printPath(a);
    }
}
