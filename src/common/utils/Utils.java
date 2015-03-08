package common.utils;

public class Utils {
    public static void printArray2(int[][]arr, int m, int n) {
    	System.out.println("=================");
    	for (int i=0; i<m;i++) {
    		for (int j=0;j<n;j++)
    			System.out.print(arr[i][j] + ",");
    		System.out.println();
    	}
    	System.out.println("=================");
    }
}
