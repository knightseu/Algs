package lc.sol2;

public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 1. check input
	 * 2. coding style, space 
	 * 3. naming of parameter
	 * 
	 */
	 public String strStr(String src, String dest) {
		 if (src == null || dest == null) {
			 return null;
		 }
		 int i, j;
		 for (i = 0; i< src.length() - dest.length() + 1; i++) {
			 for (j = 0; j < dest.length(); j++) {
				 if (src.charAt(i+j) != dest.charAt(j)) {
					 break;
				 }
			 }
			 if (j ==  dest.length()) {
				 return src.substring(i);
			 }
		 }
		 return null;
	 }
}
