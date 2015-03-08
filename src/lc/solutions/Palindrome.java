package lc.solutions;

public class Palindrome {
/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
	public boolean isPalindrome(String s) {
        int len= s.length();
        if (len==0) return true;
        int left=0, right=len-1;
        while (left<right) {
        	while ((left<len) && !isvalid(s.charAt(left))) left++;
        	while ((right>=0) && !isvalid(s.charAt(right))) right--;
        	if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                break;
            } else {
                left++;
                right--;
            }
        }
        return (left>=right);	
    }
	
	private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
