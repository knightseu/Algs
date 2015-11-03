package lint.ladder4.required;
/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Have you met this question in a real interview? Yes
Example
Given an example n=3 , 1+1+1=2+1=1+2=3

return 3

 * @author xuanlin
 *
 */
public class ClimblingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * 1. state: f[i], # of ways to step i
	 * 2. function: f[i] = f[i-1] + f[i-2]
	 * 3. initial: f[0] = 1; f[1] = 1;
	 * 4. final state : f[n]
	 */
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n <= 1) {
        	return n;
        }
        
        int nMinus1 = 1, nMinus2 = 1;
        int N = 0;
        for (int i = 2; i <= n; i++) {
        	N = nMinus1 + nMinus2;
        	nMinus2 = nMinus1;
        	nMinus1 = N; 
        }
        
        return N;
    }

}
