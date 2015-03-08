package lc.solutions;
/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 
 */
public class SearchInsertPosition {
	/*
	 * similar to binary search + exit condition check
	 */
    public int searchInsert(int[] A, int target) {
    	 if (null == A || A.length == 0) return 0;
         if (A.length == 1) return A[0]>=target?0:1;
         int l=0, r = A.length-1;
         while (l<=r) {
             if (target<=A[l]) return l;
             if (target>A[r]) return r+1;
             int m = (l+r)/2;
             if (target == A[m]) return m;
             if (target > A[m]) 
             	l=m+1;
             else
             	r=m-1;
         }
         return l+1;
    }
}
