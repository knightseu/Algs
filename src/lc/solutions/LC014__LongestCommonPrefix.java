package lc.solutions;
/*
 * Write a function to find the longest common prefix string amongst an array of strings. 
 */
public class LC014__LongestCommonPrefix {

	//start from the first one, compare prefix with next string, until end;
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) { 
            int j = 0;
            while( j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if( j == 0) {
                return "";
	        }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
