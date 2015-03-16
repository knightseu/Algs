package lc.solutions;

import java.util.TreeSet;

/*
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

 */
public class LC044_WildcardMatching {
	public boolean isMatch(String s, String p) {
	    // without this optimization, it will fail for large data set
	    int plenNoStar = 0;
	    for (char c : p.toCharArray())
	        if (c != '*') plenNoStar++;
	    if (plenNoStar > s.length()) return false;

	    s = " " + s;
	    p = " " + p;
	    int slen = s.length();
	    int plen = p.length();

	    boolean[] dp = new boolean[slen];
	    TreeSet<Integer> firstTrueSet = new TreeSet<Integer>();
	    firstTrueSet.add(0);
	    dp[0] = true;

	    boolean allStar = true;
	    for (int pi = 1; pi < plen; pi++) {
	        if (p.charAt(pi) != '*')
	            allStar = false;
	        for (int si = slen - 1; si >= 0; si--) {
	            if (si == 0) {
	                dp[si] = allStar ? true : false;
	            } else if (p.charAt(pi) != '*') {
	                if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') dp[si] = dp[si-1];
	                else dp[si] = false;
	            } else {
	                int firstTruePos = firstTrueSet.isEmpty() ? Integer.MAX_VALUE : firstTrueSet.first();
	                if (si >= firstTruePos) dp[si] = true;
	                else dp[si] = false;
	            }
	            if (dp[si]) firstTrueSet.add(si);
	            else firstTrueSet.remove(si);
	        }
	    }
	    return dp[slen - 1];
	}

	//solution from http://blog.csdn.net/linhuanmars/article/details/21198049
    public boolean isMatchII(String s, String p) {  
        if(p.length()==0)  
            return s.length()==0;  
        boolean[] res = new boolean[s.length()+1];  
        res[0] = true;  
        for(int j=0;j<p.length();j++)  
        {  
            if(p.charAt(j)!='*')  
            {  
                for(int i=s.length()-1;i>=0;i--)  
                {  
                    res[i+1] = res[i]&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j));  
                }  
            }  
            else  
            {  
                int i = 0;  
                while(i<=s.length() && !res[i])  
                    i++;  
                for(;i<=s.length();i++)  
                {  
                    res[i] = true;  
                }  
            }  
            res[0] = res[0]&&p.charAt(j)=='*';  
        }  
        return res[s.length()];  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
