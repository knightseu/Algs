package lint.ladder9.required;

import java.util.Arrays;

/**
 * Created by xuanlin on 2/28/17.
 * 603
 *
 *http://www.jiuzhang.com/solutions/perfect-squares/
 * https://www.cnblogs.com/grandyang/p/4800552.html
 */
public class PerfectSquares {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i=0; i*i<=n; i++) {
            dp[i*i] = 1;
        }

        for (int i = 0; i<=n; i++) {
            for (int j=1; i+j*j<=n; j++) {
                dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1);
            }
        }
        return dp[n];
    }
}


/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Have you met this question in a real interview? Yes
Example
Given n = 12, return 3 because 12 = 4 + 4 + 4
Given n = 13, return 2 because 13 = 4 + 9
 */
