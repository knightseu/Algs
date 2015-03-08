package lc.solutions;

import java.util.ArrayList;
import java.util.List;

import common.datastructure.TreeNode;


public class TreeUniqueBinaryTrees {

	//recursive version
		public List<TreeNode> generateTrees(int n) {
			List<TreeNode> rst = new ArrayList<TreeNode>();
			if (0 == n) 
				rst.add(null);
			else       
		        rst = genTrees(1, n);
		    return rst;
		}
		
		//dp version
	    public List<TreeNode> generateTrees2(int n) {
	    	List<TreeNode> rst= new ArrayList<TreeNode>();
	    	
	    	if ( 0 == n ) return rst;
	    	
	    	//trees[m][n] - m, total number of nodes; n, the starting node.
	    	List<TreeNode> [][]trees = new ArrayList [n+1][n+1]; 
	    	for (int i=0; i<=n; i++)
	    		for (int j=0; j<=n; j++) {
	    			trees[i][j] = new ArrayList<TreeNode>();
	    			if (0==i) trees[i][j].add(null);
	    		}
	    	
	    	for (int i=1;i<=n; i++)
	    	{
	    		TreeNode treenode= new TreeNode(i);
	    		treenode.left=null; treenode.right=null;
	    		trees[1][i].add(treenode);
	    	}
	    	
	    	for (int num = 2; num<=n; num++) //number of node
	    		for (int i=1; i<=n-num+1; i++) //starting index
	    		{
	    			for (int j=i; j<=i+num-1; j++) //j is thee root node position
	    			{
	    	            int left = j-i, right = num - left -1;
	    	            //1.create root node;
	    	            
	    	            List<TreeNode> leftTrees = trees[left][i];
	    	            List<TreeNode> rightTrees = trees[right][j+1>n ? n : j+1];  //todo: check boundary for j+1
	    	            for (TreeNode lTree : leftTrees)
	    	            	for (TreeNode rTree: rightTrees) {
	    	            		TreeNode treenode = new TreeNode(j);
	    	            		treenode.left = lTree;
	    	            		treenode.right = rTree;
	    	            		trees[num][i].add(treenode);
	    	            	}
	    			}
	    		}
	        return trees[n][1];
	    }
	    
	    //recursive version
	    public ArrayList <TreeNode> genTrees(int start, int end) {
	    	ArrayList<TreeNode> rst= new ArrayList<TreeNode>();
	    	if (start > end)
	    		rst.add(null);// we need add null here, other wise there is no element is this partition, we will lose one combination in the following steps.
	    	else if (start == end)
	    	    rst.add(new TreeNode(start));
	    	else {
	    	    for (int i=start; i<=end; i++) { // i is the root
	    	        ArrayList<TreeNode> lTree = genTrees(start, i-1);	
	    	        ArrayList<TreeNode> rTree = genTrees(i+1, end);
	    	        
	    	        //all possible combination of left tree and right tree
	    	        for (TreeNode lNode: lTree)
	    	        	for (TreeNode rNode:rTree)
	    	        	{
	    	        		TreeNode root = new TreeNode(i);
	    	        		root.left = lNode;
	    	        		root.right = rNode;
	    	        		rst.add(root);
	    	        	}
	    	    }
	    	}
	    	
	    	return rst;
	    }


}
