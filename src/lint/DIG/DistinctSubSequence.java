package lint.DIG;

/**
 * Created by xuanlin on 2/25/17.
 *
 * http://www.lintcode.com/en/problem/distinct-subsequences/
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-distinct-subsequences.html
 */
public class DistinctSubSequence {
    public static int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        int[][] nums = new int[S.length() + 1][T.length() + 1];

        //intialize
        for (int i = 0; i < S.length(); i++) {
            nums[i][0] = 1;
        }
        //dynamic,
        // nums[i][j] = nums[i-1][j] + nums[i-1][j-1], equal
        // nums[i][j] = nums[i-1][j], not equal
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                nums[i][j] = nums[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }
        return nums[S.length()][T.length()];
    }

    public static void main (String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
    }
}
