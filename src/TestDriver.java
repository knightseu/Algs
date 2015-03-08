import java.awt.List;
import java.util.ArrayList;

import common.datastructure.TreeNode;
import common.datastructure.TreeUtils;
import common.datastructure.UndirectedGraphNode;
import lc.solutions.GenerateDict;
import lc.solutions.GraphClone;
import lc.solutions.InterleavingString;
import lc.solutions.NQueen;
import lc.solutions.NextPermutation;
import lc.solutions.PascalTri;
import lc.solutions.SearchRange;
import lc.solutions.SearchRotatedSortedArray;
import lc.solutions.SimplifyPath;
import lc.solutions.TreeConstructBinaryTreeInorderPostorder;
import lc.solutions.TreeConstructBinaryTreePreorderInorder;
import lc.solutions.TreePathSum;


public class TestDriver {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 
		 */
		/*TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		node1.left = node2;
		node1.right = node3;
		node3.left =node4;
		node4.right=node5;
		node4.left=node6;
		TreeUtils.printTree(node1);*/

		
		/*
		Solution sln = new Solution();
		
		ArrayList<TreeNode> trees = (ArrayList<TreeNode>)sln.generateTrees2(3);
		//ArrayList<TreeNode> trees = (ArrayList<TreeNode>)sln.generateTrees(3);
		for (TreeNode treenode: trees)
		    TreeUtils.printTree(treenode);
		System.out.println("Total number of trees: " + trees.size());*/
		
		/*
		int postorder[] = new int[] {2,1};
		int inorder[] = new int[]{2,1};
		TreeConstructBinaryTreeInorderPostorder.buildTree(inorder, postorder);
		*/
		
		/*
		ArrayList<ArrayList<Integer>> rst = PascalTri.generate(10);
		for (ArrayList<Integer> row: rst) {
			System.out.print("[ ");
			for (Integer i: row)
				System.out.print(i + " ");
			System.out.println("]");
			
		}
		*/
		
		/*
		TreeNode node1 = new TreeNode(-2);
		TreeNode node2 = new TreeNode(-3);
		node1.right = node2;
		
		boolean rst =  TreePathSum.hasPathSum(node1, -5);
		System.out.println(rst);
		*/
		
		/*
		int []num = {1,2};
		NextPermutation.nextPermutation(num);
		*/
		//int [] A ={2,2};
		//SearchRange.searchRange(A, 2);
		
		//System.out.println(SimplifyPath.simplifyPath("/..."));
		
		/*
		String s="abcdefg";
		System.out.println("full:"+s);
		System.out.println("2-3:"+s.substring(1,2));
		System.out.println("2-4:"+s.substring(1,3));
		System.out.println("2-5:"+s.substring(1,4));
		System.out.println("2-6:"+s.substring(1,5));*/
		
		//GenerateDict.getDict();
		//NQueen nq= new NQueen();
		//System.out.println(nq.totalNQueens(2));
		
		
		//clone graph
		/*
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		node0.neighbors.add(node1);
		node1.neighbors.add(node2);
		node2.neighbors.add(node2);
		UndirectedGraphNode newnode = GraphClone.cloneGraph(node0);
		*/
		
		String s1= "a", s2="b", s3="ab";
		InterleavingString.isInterleave(s1, s2, s3);
		System.out.println("=====Done=====");
	}
	
	

}
