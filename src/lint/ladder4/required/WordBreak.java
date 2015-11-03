package lint.ladder4.required;

import java.util.Set;

/*
 * Medium Word Break

12% Accepted
Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

Have you met this question in a real interview? Yes
Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".
 */
public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        /*
         * 1. State: canBreak[i], 0-i can be break
         * 2. func: canBreak[i] = canBreak[j], j<i, j+~i in dict
         * 3. initial: canBreak[0]
         */
    }

}
