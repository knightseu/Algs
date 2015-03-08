package lc.solutions;

import java.util.Stack;

public class LongestValidParentheses {
	/*
	 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
	 */
	
	/*
	 * Notes:
	 * 1. record position start when fail (stack is empty
	 * 2. after pop, if stack is empty, use 'i-start', otherwise, use 'i-stack.peek()'
	 */
    public int longestValidParentheses(String s) {
    	int start =-1, maxlen = 0;
    	Stack<Integer> st = new Stack<Integer>();
    	for (int i=0; i<s.length();i++) {
    		if (s.charAt(i) == '(')
    			st.push(i);
    		else {
    			if (st.isEmpty())
    				start = i;
    			else {
    				st.pop();
    				if (st.isEmpty()) {
    					maxlen = Math.max(i-start, maxlen);
    				}
    				else {
    					maxlen = Math.max(i-st.peek(), maxlen);
    				}
    			}
    		}
    	}
    	return maxlen;
        
    }
}
