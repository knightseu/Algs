package lc.solutions;

/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
 */
public class SearchRange {
	/*
	 * Notes:
	 * 1.when we’re doing a binary search in Search Insert Position, we ‘assume’ there’s nothing repeated. 
	 * Now that there’s duplicate numbers in the array, we can’t exit the loop when the mid hit the result
	 * 2.double search, first search for low, second search for high
	 * 3.pay attention to which side you should search and the stop condition
	 */
    public static int[] searchRange(int[] A, int target) {
        int [] rst = {-1,-1};
        if (null==A || A.length ==0) return rst;
        int l=0, r=A.length-1;
        while (l<r) {
        	int m = (l+r)/2;
        	if (A[m]<target)
        		l=m+1;
        	else 
        		r=m;
        }
        if (A[l]==target)
        	rst[0] = l;
        else
        	return rst;
        //find the right
        r = A.length -1;
        while (l<r) {
        	int m = (l+r)/2;
        	if (A[m]>target)
        		r=m-1;
        	else 
        		l=m+1;
        }
        if (A[l] == target)
            rst[1] = l;
        else
        	rst[1] = l-1;
        return rst;
    }
}
