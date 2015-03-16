package lc.solutions;

public class LC055_JumpGame {
	
	//DP
	
	  public boolean canJump(int[] A) {
	        boolean[] can = new boolean[A.length];
	        can[0] = true;
	        
	        for (int i = 1; i < A.length; i++) {
	            for (int j = 0; j < i; j++) {
	                if (can[j] && j + A[j] >= i) {
	                    can[i] = true;
	                    break;
	                }
	            }
	        }
	        
	        return can[A.length - 1];
	    }
	  
	  //Greedy
	
	  public boolean canJumpGreedy(int[] A) {
	        // think it as merging n intervals
	        if (A == null || A.length == 0) {
	            return false;
	        }
	        int farthest = A[0];
	        for (int i = 1; i < A.length; i++) {
	            if (i <= farthest && A[i] + i >= farthest) {
	                farthest = A[i] + i;
	            }
	        }
	        return farthest >= A.length - 1;
	    }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
