package lint.ladder4.required;
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Have you met this question in a real interview? Yes
Example
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {

	public static void main(String[] args) {
		int A[] = {13,52,42,21,58};
		System.out.println(jump(A));

	}
	
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public static int jump(int[] A) {
        /*
         * 1. f[i], minimum jump to i
         * 2. function, f[i] = min (f[j]+1), where j+f[j] > i.
         * 3. initial state: f[0] = 0;
         * 4. goal: f[n-1]
         */
    	if (A == null || A.length == 0) {
    		return -1;
    	}
    	int n = A.length;
    	int []f = new int[n];
    	f[0] = 0;
    	for (int i = 1; i < n; i++) {
    		f[i] = Integer.MAX_VALUE;
    	}
    	for (int i = 1; i < n; i++) {
    		for (int j = 0; j < i; j++) {
    			if (A[j] + j >= i && f[j] + 1 < f[i]) {
    				f[i] = f[j] + 1;
    			}
    		}
    	}
    	return f[n-1];
    }

}
