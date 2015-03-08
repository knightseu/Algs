package lc.solutions;

public class LC010_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return false;
        if (s.length() == 0) return allowEmpty(p);
        
        char s1 = s.charAt(0);
        char d1 = p.charAt(0),  d2='0'; //assign d2 to a value which is not '*'
        if (p.length()>1) d2 = p.charAt(1);
        if (d2 == '*') {
        	if (equals(s1, d1)) {
        		return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
        	}
        	else {
        		return isMatch(s, p.substring(2));
        	}
        }
        else {
        	if (equals(s1, d1)) 
        		return isMatch(s.substring(1), p.substring(1));
        	else
        		return false;
        }
        
    }
    
    public boolean equals(char s1, char p1) {
    	return p1 == '.' || s1 ==  p1;
    }
    
    //'*' Matches zero or more of the preceding element.
    public boolean allowEmpty(String p) {
    	//'*' has to be in the odd position
    	if (p.length()%2 !=0) return false;
    	for (int i=1; i<p.length(); i+=2) {
    		if (p.charAt(i) != '*') return false;
    	}
    	return true;
    }
    
    
    /////

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
