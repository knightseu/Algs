package lint.ladder4.required;
/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Have you met this question in a real interview? Yes
Example
For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4

Challenge
Time complexity O(n^2) or O(nlogn)

Clarification
What's the definition of longest increasing subsequence?

    * The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.  

    * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * @author xuanlin
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // 1. state - seq[i], the length of longest increasing subsequence  till i
    	// 2. func -  seq[i] = max (seq[j])+1, where nums[i] >= nums[j]
    	// 3. initial - seq[i] = 1
    	// 4. goal - max(seq[i])
    	 int []f = new int[nums.length];
         int max = 0;
         for (int i = 0; i < nums.length; i++) {
             f[i] = 1;
             for (int j = 0; j < i; j++) {
                 if (nums[j] <= nums[i]) {
                     f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                 }
             }
             if (f[i] > max) {
                 max = f[i];
             }
         }
         return max;
    }

}
