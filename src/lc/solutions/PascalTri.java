package lc.solutions;

import java.awt.List;
import java.util.ArrayList;

public class PascalTri {
/*
 * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
 [1,5,10,10,5,1]
]
 */
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>(); 
        ArrayList<Integer> curRow;
        if ( 0 == numRows) return rst;
        curRow = new ArrayList<Integer>();
        curRow.add(1);
        rst.add(curRow);
        if (1 == numRows) return rst;
        
        curRow = new ArrayList<Integer>();
        curRow.add(1);
        curRow.add(1);
        rst.add(curRow);
        if (2 == numRows) return rst;
        ArrayList<Integer> lastRow = curRow;
        curRow = new ArrayList<Integer>();
        
        for (int i=3;i<=numRows;i++) {
            curRow.add(1);
        	for (int j=1; j<i-1; j++) 
        		curRow.add(lastRow.get(j-1) + lastRow.get(j));
        	curRow.add(1);
        	rst.add(curRow);
        	lastRow = curRow;
        	curRow = new ArrayList<Integer>(); 
        }
        return rst;
    }
    public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> curRow = new ArrayList<Integer>();
        if (0==rowIndex)
        	return curRow;
        curRow.add(1);
        if (1==rowIndex) return curRow;
        ArrayList<Integer> lastRow = curRow;
        for (int i=2;i<=rowIndex;i++) {
        	curRow = new ArrayList<Integer>();
        	curRow.add(1);
        	for (int j=1; j<i-1; j++) 
        		curRow.add(lastRow.get(j-1) + lastRow.get(j));
        	curRow.add(1);
        	lastRow = curRow;
        }
        return curRow;
    }
    
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        return 0;
    }
}
