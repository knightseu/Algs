package lint.ladder2.required;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Have you met this question in a real interview? Yes
Example
For [4, 5, 1, 2, 3] and target=1, return 2.

For [4, 5, 1, 2, 3] and target=0, return -1.

 * @author xuanlin
 *
 */
public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // draw the graph, things will be easier
    	if (A == null || A.length == 0) {
    		return -1;
    	}
    	
    	int start = 0;
    	int end = A.length - 1;
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (A[mid] == target) {
    			return mid;
    		}
    		if (A[start] < A[mid]) {
    			
    			if (A[start] <= target && A[mid] >= target) {
    				end = mid;
    			} else {
    				start = mid;
    			}
    		} else {
    			if (target <= A[end] && target >= A[mid]) {
    				start = mid;
    			} else {
    				end = mid;
    			}
    		}
    	}
    	
    	if (A[start] == target) {
    		return start;
    	}
    	if (A[end] == target) {
    		return end;
    	}
    	return -1;
    }
}
