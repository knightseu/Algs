package lc.solutions;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
/*
 * Notes:
 * 1. use >= or <=
 * 2. still binary search, just be careful when judging which side should be discarded.
 */
public class SearchRotatedSortedArray {
    public static int search(int[] A, int target) {
    	int l=0, r = A.length-1;
        while (l<=r) {
        	int m = (l+r)/2;
        	if (A[m]== target) return m;
        	if (A[m]>=A[l]) { // the left side is sorted, and right side is rotated
        		if (target>=A[l] && target<=A[m])
        			r = m-1;
        		else
        			l = m+1;
        	}
        	else {
        		if (target<=A[r] && target>=A[m])
        			l = m+1;
        		else
        			r = m-1;
        	}
        }
        return -1;
    }
    
    /*
     * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

     */
    /*
     * worst casee could be O(n), since A[m]>A[l] can not tell the order
     * 
     * 
     *  
     */
    public static int search2(int[] A, int target) {
    	return -1;
    }
}
