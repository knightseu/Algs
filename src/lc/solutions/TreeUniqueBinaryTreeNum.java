package lc.solutions;
/**
 * 
 * @author xuanlin
 * 
 * Notes: Assuming 1..n nodes, 
 * 1. when i is the root, the possible number = Num of left tree* Num of right tree
 * 2. when i is the root, the left tree is 1..i-1, the right tree is i+1..n
 * 
 */
public class TreeUniqueBinaryTreeNum {
    public int numTrees(int n) {
    	if (0==n) return 1;
    	int [] count = new int[n+1];
    	count[0] = 1;
    	count[1] = 1;
    	for (int i=2; i<=n; i++) 
    	{
    		for (int j=1; j<=i; j++)
    		{
    			count[i] += count[j-1]*count[i-j];
    		}
    	}
        return count[n];
    }
}
