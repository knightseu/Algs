package common.datastructure;

/**
 * Created by xuanlin on 2/26/17.
 */
public class ParentTreeNode {
    public int val;
    public ParentTreeNode left;
    public ParentTreeNode right;
    public ParentTreeNode parent;
    public ParentTreeNode(int x) { val = x; }
    public ParentTreeNode() {
        val = 0;
        left = null;
        right = null;
        parent = null;
    }
}
