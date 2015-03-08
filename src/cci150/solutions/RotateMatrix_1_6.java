package cci150.solutions;

import common.utils.Utils;

public class RotateMatrix_1_6 {
    public void rotateMatrix(int[][]m, int N) {
    	int round = N/2;
    	//i is the index of round
    	//j is the index of current element for each row
    	for (int i=0; i<round; i++) {
    		//
    		int len = N-i*2-1;
    		for (int j =0; j<len; j++) {
    			//1. save top
    			int tmp= m[i][j+i];
    			//2. left->top
    			m[i][j+i] =m[N-i-j-1][i];  
    			
    			//3. bottom->left
    			m[N-i-j-1][i] = m[N-i-1][N-i-j-1];
    			
    			//4. right->bottom
    			m[N-i-1][N-i-j-1] = m[i+j][N-i-1];
    			
    			//5. top->right
    			m[i+j][N-i-1] = tmp;
    		}
    	}
    	Utils.printArray2(m, N, N);
    }
    
    public void spiralPrint(int[][]m, int N) {
    	int round = N/2;
    	for (int i=0; i<round; i++) {
    		int len = N-i*2-1;
    		for (int j=0; j<len; j++) 
    			//top
    			System.out.print(m[i][j+i] + ",");
    		for (int j=0; j<len; j++)
    			//right
    			System.out.print(m[j+i][N-i-1] + ",");
    		for (int j=0; j<len; j++)
    			//bottom
    			System.out.print(m[N-i-1][N-i-j-1] + ",");
    		for (int j=0; j<len; j++)
    			//left
    			System.out.print(m[N-i-j-1][i] + ",");
    		
    	}
    	if (round*2<N) System.out.println(m[round][round]);
    }
    
    public void spiralPrint(int[][]arr, int M, int N) {
    	int round = Math.min(M, N)/2;
    	for (int i=0; i<round; i++) {
    		int lenX = N-i*2-1;
    		int lenY = M-i*2-1;
    		for (int j=0; j<lenX; j++) 
    			//top
    			System.out.print(arr[i][j+i] + ",");
    		for (int j=0; j<lenY; j++)
    			//right
    			System.out.print(arr[j+i][N-i-1] + ",");
    		for (int j=0; j<lenX; j++)
    			//bottom
    			System.out.print(arr[M-i-1][N-i-j-1] + ",");
    		for (int j=0; j<lenY; j++)
    			//left
    			System.out.print(arr[M-i-j-1][i] + ",");
    		
    	}
    	
    	if (round*2<Math.min(M, N)) {
    		
    		if (M>N) {
    			int lenY = M-round*2;
    			for (int j=0;j<lenY; j++)
    				System.out.print(arr[j+round][round] + ",");
    		}
    		else {
    			int lenX = N-round*2;
    			for (int j=0; j<lenX;j++)
    				System.out.print(arr[round][j+round] + ",");
    		}
    		
    	}
    }
    
    
    public static void main(String[] args) {
         System.out.println("test...");	
         int [][] m1 = new int[][] {
        		 {1,2,3,4,5}, 
        		 {6,7,8,9,10},
        		 {11,12,13,14,15},
        		 {16,17,18,19,20},
        		 {21,22,23,24,25}
         };
         int [][] m2 = new int[][] {
        		 {1,2,3,4}, 
        		 {5,6,7,8},
        		 {9,10,11,12},
        		 {13,14,15,16}
         };
         int [][] m3 = new int[][] {
        		 {1,2,3,4,5,6,7}, 
        		 {8,9,10,11,12,13,14},
        		 {15,16,17,18,19,20,21},
        		 {22,23,24,25,26,27,28},
        		 {29,30,31,32,33,34,35}
         };
         Utils.printArray2(m3, 5, 7);
         RotateMatrix_1_6 rm = new RotateMatrix_1_6();
         //rm.rotateMatrix(m1, 5);
         //Utils.printArray2(m2, 4, 4);
        // rm.rotateMatrix(m2, 4);
        // rm.spiralPrint(m1, 5);
         
         rm.spiralPrint(m3, 5, 7);
    }
}
