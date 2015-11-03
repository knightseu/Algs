package lint.ladder5.required;
/*
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Have you met this question in a real interview? Yes
Example
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
Challenge
O(n2) time or better
 */
public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // 1.state - dis[i][j]: s3[i+j-1] can be interleaved by s1[i-1], s2[j-1]
    	// 2.func - dis[i][j] = dis[i-1][j] && s3[i+j-1] == s1[i-1]
    	//                    = dis[i][j-1] && s3[i+j-1] == s2[j-1]
    	// 3.dis[0][0]
    	// 4.dis[m][n]
    	if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
    		return false;
    	}
    	boolean [][]isInterleaved = new boolean[s1.length() + 1] [s2.length() + 1];
    	isInterleaved[0][0] = true;
    	for (int i = 1; i <= s1.length(); i++) {
    		if (s3.charAt(i-1) == s1.charAt(i - 1) && isInterleaved[i - 1][0]) {
    			isInterleaved[i][0] = true;
    		}
    	}
    	for (int j = 1; j <= s2.length(); j++) {
    		if (s3.charAt(j - 1) == s2.charAt(j - 1) && isInterleaved[0][j - 1]) {
    			isInterleaved[0][j] = true;
    		}
    	}
    	
    	for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && isInterleaved[i - 1][j]))
                    || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && isInterleaved[i][j - 1]))
                	isInterleaved[i][j] = true;
            }
        }
        
        return isInterleaved[s1.length()][s2.length()];
    	
    }

}
