package lint.ladder4.required;
/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Have you met this question in a real interview? Yes
Example
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Note
This problem have two method which is Greedy and Dynamic Programming.

The time complexity of Greedy method is O(n).

The time complexity of Dynamic Programming method is O(n^2).

We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.

 * @author xuanlin
 *
 */
public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * 1. state: can[i], can jump to index i
	 * 2. can[i]= any j<i, can[j] && A[j] + j >= i
	 * 3. initial state, can[0] = true;
	 * 4. goal, can[n-1]
	 */
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
    	if (A == null) {
    		return false;
    	}
    	
    	int n = A.length;
        boolean []can = new boolean[n];
        can[0] = true;
        for (int i = 1; i < n; i++) {
        	can[i] = false;
        }
        
        for (int i = 1; i < n; i++) {
        	for (int j = 0; j < i; j++) {
        		if (can[j] && A[j] + j >= i) {
        			can[i] = true;
        			break;
        		}
        	}
        }
        return can[n-1];
    }

}
