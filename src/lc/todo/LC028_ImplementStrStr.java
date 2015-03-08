package lc.todo;
/*
 *  Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Update (2014-11-02):
The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button to reset your code definition. 
 */
public class LC028_ImplementStrStr {
	 public String strStr(String haystack, String needle) {
	        if(haystack == null || needle == null) {
	            return null;
	        }
	        int i, j;
	        for(i = 0; i < haystack.length() - needle.length() + 1; i++) {
	            for(j = 0; j < needle.length(); j++) {
	                if(haystack.charAt(i + j) != needle.charAt(j)) {
	                    break;
	                }
	            }
	            if(j == needle.length()) {
	                return haystack.substring(i);
	            }
	        }
	        return null;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
