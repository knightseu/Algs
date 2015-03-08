package lc.solutions;
/*
 *  Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 */
public class EditDistance {
	/*
	 * 1. Get formular first, E(i,j) = min(E(i-1, j-1)+R, E(i-1,j) +I, E(i,j-1)+D)
	 * 2. base case
	 * 3. both recursive and dp will work
	 * 4. string index should be -1 compare to distance array
	 */
    public int minDistance(String word1, String word2) {
    	int m = word1.length(), n= word2.length();
        if (m==0) return n;
        if (n==0) return m;
        int [][]distance = new int[m+1][n+1];
        for (int i=0;i<=m;i++)
        	distance[i][0] = i;
        for (int i=0;i<=n;i++)
        	distance[0][i] = i;
        
        for (int i=1;i<=m;i++) {
        	char x = word1.charAt(i-1);
        	for (int j=1; j<=n;j++) {
        		char y=word2.charAt(j-1);
        		if (x == y)
        			distance[i][j] = distance[i-1][j-1];
        		else {
        			int replace = distance[i-1][j-1]+1;
        			int delete=distance[i][j-1]+1;
        			int insert=distance[i-1][j]+1;
        			int min = Math.min(replace, delete);
        			distance[i][j] = Math.min(min, insert);
        		}
        	}
        }
        return distance[m][n];
    }
}
