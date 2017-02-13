package lint.ladder4.BFS;

import common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xuan on 2/9/17.
 */
public class BinaryTreeSerialization {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public  String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        LinkedList<TreeNode> que_level = new LinkedList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            Boolean emptyLevel = true;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (null == node) {
                        sb.append("#,");
                    } else {
                        sb.append(node.val);
                        sb.append(',');
                        queue.offer(node.left);
                        queue.offer(node.right);
                        emptyLevel = false;
                    }
                }
            }

        sb.replace(sb.length()-1, sb.length()-1, "}");
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        BinaryTreeSerialization bts = new BinaryTreeSerialization();
        System.out.println(bts.serialize(a));
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        return null;
    }
}



/*
Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

There is no limit of how you deserialize or serialize a binary tree, you only need to make sure you can serialize a binary tree to a string and deserialize this string to the original structure.

Have you met this question in a real interview? Yes
Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.


 */