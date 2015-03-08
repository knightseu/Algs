package lc.solutions;
/**
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. 
 * @author xuanlin
 *
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        return canJumpHelper(A,0);
    }
    private boolean canJumpHelper(int[] A, int curIndex) {
    	if (curIndex==A.length) return false;
    	int nextIndex = A[curIndex]+curIndex;
    	if (nextIndex>=A.length) 
    		return true;
    	else {
    		for (int j=curIndex+1; j<=nextIndex;j++) {
    			if (canJumpHelper(A,j)) {
    				return true;
    			}
    		}
    	}
    	return false;

    }
    
    //DP SOLUTION
    public boolean canJump2(int[] A) {
        if (A.length == 1) return true;
        if (A[0] == 0) return false;
        int maxJump = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            maxJump = Math.max(maxJump - 1, A[i]);
            if (maxJump == 0) {
                return false;
            }
        }

        return true;
    }
    
    
}
