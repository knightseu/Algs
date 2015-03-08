package lc.solutions;
/*
 *  Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3]. 
 */
public class RemoveDuplicatesArrayII {
	/*
	 * Notes:
	 * 1. use an index to keep track of last element as well as the current count of same element.
	 * 2. always ask how to handle null input.
	 */
    public int removeDuplicates(int[] A) {
        if (A.length<3) return A.length;
        int index=0, count = 1;
        for (int i=1; i<A.length; i++) {
        	if (A[i] == A[index]) {
        		if (count == 2) continue;
        		count++;
        	}
        	else
        		count = 1;
        	A[++index] = A[i];
        }
        return index+1;
    }
}
