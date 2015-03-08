package lc.solutions;

import java.util.Stack;

public class ValidParentheses {
	/**
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 * @param s
	 * @return
	 * 
	 * 
	 * Notes:
	 * 
	 * 1. "blah".contains()
	 * 2. String.valueOf(c)
	 * 3. Stack<Character>
	 * 4. for (Character c : s.toCharArray())
	 */
    public boolean isValid(String s) {
    	Stack<Character> st = new Stack<Character>();
    	for (Character c : s.toCharArray()) {
            if ("({[".contains(String.valueOf(c))) {
            	st.push(c);
            }
            else {
            	if (!st.empty()) {
            		Character c1 = st.peek();
            		if ( (c1 == '(' && c == ')') || (c1 == '{' && c == '}') || (c1 == '[' && c == ']'))
            		    st.pop();
            		else
            			return false;
            	}
            	else return false;
            }
    	}
    	return st.isEmpty();
        
    }
}
