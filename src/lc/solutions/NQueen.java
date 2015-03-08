package lc.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

http://www.2cto.com/kf/201311/256634.html
http://www.cnblogs.com/TenosDoIt/p/3801621.html

 */
public class NQueen {
	private static int up_lim = 1, count=0;
    public static List<String[]> solveNQueens(int n) {
        int [] queenPos = new int[n];
        Arrays.fill(queenPos, -1);
        ArrayList<String[]> rst = new ArrayList<String[]>();
        placeQueen(queenPos, 0, n, rst);
        return rst;
    }
    
    /**
     * 
     * @param queenPos, array to keep tracking exisiting Position of Queens
     * @param row, which row we are trying to place Queen
     * @param n, total number of Queens we have to place
     * @param rst, where we store possible solutions.
     */
    public static void placeQueen(int[] queenPos, int row, int n, ArrayList<String[]> rst){
        if (row == n) { //ok, we find solution here
            StringBuilder [] ss = new StringBuilder[n];
        	for (int i=0; i<n;i++) {
        		ss[i] = new StringBuilder();
        		for (int j=0;j<n; j++) {
        			ss[i].append(".");
        		}
        	}
        	for (int i=0; i<n;i++) 
        		ss[i].setCharAt(queenPos[i], 'Q');
        	String [] sol = new String[n];
        	for (int i=0; i<n; i++)
        		sol[i] = ss[i].toString();
        	rst.add(sol);
        }
        else {
        	for (int col=0; col<n;col++) {
        		if (isValidQueen(queenPos, row, col)){
        			queenPos[row] = col;
        			placeQueen(queenPos, row+1, n, rst);
        			queenPos[row] = -1;
        		}
        	}
        }
    }
    
    public static boolean isValidQueen(int[] queenPos, int row, int  col) {
    	for (int i=0; i<row; i++) {
    		int preCol=queenPos[i];
    		if (col == preCol || Math.abs(row -i) == Math.abs(col - preCol))
    			return false;
    	}
    	return true;
    }
    
    
    //simplified version of above solution.
    public int totalNQueens(int n) {
    	up_lim = (up_lim<<n) -1;
    	count=0;
    	helper(0,0,0);
        return count;    
    }
    
    private void helper(int row, int ld, int rd) {
    	int pos, p;
    	if (row!=up_lim) { //cur row still have room for queen
    		//1. calculate the possible position
    		pos = up_lim & (~(row | rd | ld));
    		while (pos!=0) {
    		    //2.get the right most positin(1)
    			p=pos & (~pos+1);
    			//3.update pos, prepare for next row
    			pos = pos -p;
    			//4.try to set next row.
    			helper(row|p, (ld|p)<<1, (rd|p)>>1);
    		}
    	}
    	else
    		count++;
    }
    
    /*
     *   private int total;
    public int totalNQueens(int n) {
        total = 0;
        int[] qPos = new int[n];
        Arrays.fill(qPos, -1);
        placeQ(qPos, 0, n);
        return total;
    }
    
    public void placeQ(int[] qPos, int row, int n) {
        if (row == n) {
            total++;
            return;
        }
        else {
            for (int col=0; col<n; col++) {
                if (isValidQueen(qPos,row, col)) {
                    qPos[row] = col;
                    placeQ(qPos, row+1, n);
                    qPos[row] = -1;
                }
            }
        }
    }
    
    public boolean isValidQueen(int[] queenPos, int row, int  col) {
    	for (int i=0; i<row; i++) {
    		int preCol=queenPos[i];
    		if (col == preCol || Math.abs(row -i) == Math.abs(col - preCol))
    			return false;
    	}
    	return true;
    }
     */
}
