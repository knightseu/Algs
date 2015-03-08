package lc.solutions;
/*
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return the minimum cuts needed for a palindrome partitioning of s. For example, given s = "aab", Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
 */
public class LC132_PalindromePartitioningII {

	/*
	 * Analysis

In these two problem, we often needs to check if the substring(i, j) of the original string is palindrome or not. So we need to save this very important information to an array to prevent checking a same substring for several times. This is a 2-D boolean array which is quite easy to generate. We can generate it from short length to long length. When s.charAt(i) is equal to s.charAt(j), if the array isPalindrome[i + 1][j – 1] is true, then we can update isPalindrome[i][j] = true.

In the first problem, we can use recursive function to generate all possible string lists.

In the second problem, if we use recursive solution, we will got TLE. So a DP solution is needed. We can use a 1-D array D[n] to save the minimum cut. For example, D[i] saves the number of minimum cut of substring(i, n). We can start from i = n – 1, and move i from right to left. When we want to get the D[i] for a new i, we can check every possible substrings from i to n, which means we can use another point j, in which j is between i and n. If substring(i, j) is a palindrome, then we can update D[i] = min(D[i], 1 + D[j + 1]).

This method can also be used in the first problem to save more time.
	 */
	
	 private boolean isPalindrome(String s, int start, int end) {
	        for (int i = start, j = end; i < j; i++, j--) {
	            if (s.charAt(i) != s.charAt(j)) {
	                return false;
	            }
	        }
	        return true;
	    }

	    private boolean[][] getIsPalindrome(String s) {
	        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

	        for (int i = 0; i < s.length(); i++) {
	            isPalindrome[i][i] = true;
	        }
	        for (int i = 0; i < s.length() - 1; i++) {
	            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
	        }

	        for (int length = 2; length < s.length(); length++) {
	            for (int start = 0; start + length < s.length(); start++) {
	                isPalindrome[start][start + length]
	                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
	            }
	        }

	        return isPalindrome;
	    }

	    public int minCut(String s) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }

	        int[] cut = new int[s.length() + 1];
	        boolean[][] isPalindrome = getIsPalindrome(s);

	        cut[0] = 0;
	        for (int i = 1; i <= s.length(); i++) {
	            cut[i] = Integer.MAX_VALUE;
	            for (int j = 1; j <= i; j++) {
	                if (isPalindrome[i - j][i - 1] && cut[i - j] != Integer.MAX_VALUE) {
	                    cut[i] = Math.min(cut[i], cut[i - j] + 1);
	                }
	            }
	        }

	        return cut[s.length()] - 1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
