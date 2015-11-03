package lint.ladder5.optional;
/**
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

Have you met this question in a real interview? Yes
Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.

Note
You can not divide any item into small pieces.

Challenge
O(n x m) time and O(m) memory.

O(n x m) memory is also acceptable if you do not know how to optimize memory.

 * @author xuanlin
 *
 */
public class BackPack {

	public static void main(String[] args) {
		int A[] = {2,3,5,7};
		System.out.println(backPack(11, A));
		System.out.println(backPack(12, A));
	}

	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public static int backPack(int m, int[] A) {
        // 1. state - f[i+1][j], if first i elements can fill full j
    	// 2. func - 2.1 f[i+1][j] = f[i][j], if first i-1 can, then first i surely can,
    	//           2.2 f[i+1][j] = j >= A[i] && f[i][j-A[i]]
    	// 3. initial, all false, f[0][0] = true;
    	// 4. goal, return max (i), where f[A.length][i] == true.
    	if (A == null || A.length == 0) {
    		return 0;
    	}
    	int n = A.length;
    	boolean [][]canFill = new boolean[n+1][m+1];
    	
    	for (int i = 0; i <=n; i++) {
    		for (int j = 0; j<=m; j++) {
    			canFill[i][j] = false;
    		}
    	}
    	canFill[0][0] = true;
    	
    	for (int i = 0; i <n; i++) {
    		for (int j = 0; j<=m; j++) {
    			canFill[i+1][j] = canFill[i][j];
    			if (j >= A[i] && canFill[i][j - A[i]]) {
    				canFill[i+1][j] = true;
    			}
    		}
    	}
    	
    	for (int i = m; i > 0; i--) {
    		if (canFill[n][i]) {
    			return i;
    		}
    	}
    	
    	return 0;
    }
}
