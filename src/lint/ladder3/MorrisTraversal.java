package lint.ladder3;

/**
 * Created by xuanlin on 2/27/17.
 *
 *
 * http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 *
 */
import common.datastructure.TreeNode;

public class MorrisTraversal {


    public static void morrisInorder(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        while ( cur != null) {
            if (cur.left == null) {
                //1. no predecessor, print current
                printNode(cur);
                cur = cur.right;
            }
            else {
                prev = cur.left;
                while (prev.right !=null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    //2.a
                    prev.right = cur;
                    cur = cur.left;
                }
                else {
                   //2.b
                    prev.right = null;
                    printNode(cur);
                    cur = cur.right;
                }
            }
        }
    }

    private static void printNode(TreeNode a) {
        System.out.print(a.val + " ");
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(6);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(7);

        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(4);
        b.left = d;
        b.right = e;

        TreeNode f = new TreeNode(3);
        TreeNode g = new TreeNode(5);
        e.left = f;
        e.right = g;

        TreeNode h = new TreeNode(9);
        c.right = h;

        TreeNode z = new TreeNode(8);
        h.left = z;

        morrisInorder(a);
    }
}
