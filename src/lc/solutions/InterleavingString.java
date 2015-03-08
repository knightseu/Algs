package lc.solutions;

public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
    	if (s3 == null)
        	return s1==null & s2==null;
        
        if (s1==null) 
        	return s3.compareTo(s2) == 0;
        if (s2==null)
        	return s3.compareTo(s1) == 0;
        
        int len1 = s1.length(), len2 = s2.length(), len3=s3.length();
        
        if (len1+len2 != len3) return false;
        
        boolean match[][] = new boolean[len1+1][len2+1];
        //base
        match[0][0]=true;
        int i=1;
        while (i<=len1 && s1.charAt(i-1) == s3.charAt(i-1)) {
        	match[i][0] = true;
        	i++;
        }
        
        i=1;
        while (i<=len2 && s2.charAt(i-1) == s3.charAt(i-1)) {
        	match[0][i] = true;
        	i++;
        }
        
        //match[i][j], s1(0-i-1), s2(0-j-1) is an interleaving of s3(0-i+j-1)
        for (i=1;i<=len1;i++)
        	for (int j=1; j<=len2;j++) {
        		char c= s3.charAt(i+j-1);
        		boolean a = (c == s1.charAt(i-1)) && match[i-1][j];
        		boolean b = (c == s2.charAt(j-1)) && match[i][j-1];
        		match[i][j] = a || b;
        	}
        return match[len1][len2];
    }
}
