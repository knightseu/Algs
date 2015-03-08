package common.datastructure;
import java.util.ArrayList;

import lc.solutions.TreeBinaryTreeLevelOrderTraversal;


public class TreeUtils {
    public static void printTree(TreeNode root){
    	ArrayList<ArrayList<Integer>> levelTrees =  TreeBinaryTreeLevelOrderTraversal.levelOrder(root);
    	System.out.println(">>>>>>>>>> Printing Tree >>>>>>>>>>");
    	for (ArrayList<Integer> curLevel: levelTrees) {
    		String str = "";
    		for (Integer curVal: curLevel) {
    			str += curVal;
    		}
    		System.out.println(str);
    	}
    	System.out.println("<<<<<<<<<<< end <<<<<<<<<<");
    }
}
