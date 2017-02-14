package lint.ladder5.DFS;


import java.util.List;
/**
 * Created by xuan on 2/14/17.
 */
public class PalindromePartitioning {
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    private void helper(String s,
                        int startIndex,
                        List<String> partition,
                        List<List<String>> results) {

    }

    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        return null;
    }
}


/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]

 */