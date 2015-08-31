package lint.ladder2.required;

import java.util.ArrayList;

/**
 * Given a sorted array of n integers, find the starting and ending position of a given target value.

If the target is not found in the array, return [-1, -1].

Have you met this question in a real interview? Yes
Example
Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].

Challenge
O(log n) time.

 * @author xuanlin
 *
 */
public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		searchRange(result, 1);

	}

	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public static ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	result.add(-1);
    	result.add(-1);
    	
    	if (A == null || A.size() == 0) {
    		return result;
    	}
    	
    	int start, end, mid;
    	
    	//search left bound
    	start = 0;
    	end = A.size() - 1;
    	while (start + 1 < end) {
    		mid = start + (end - start) / 2;
    		if (A.get(mid) == target) {
    			end = mid;
    		} else if (A.get(mid) < target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if (A.get(start) == target) {
    		result.set(0, start);
    	} else if (A.get(end) == target) {
    		result.set(0, end);
    	} else {
    		result.set(0, -1);
    		result.set(1, -1);
    		return result;
    	}
     	
    	//search right bound
    	start = 0;
    	end = A.size() - 1;
    	while (start + 1 < end) {
    		mid = start + (end - start) / 2;
    		if (A.get(mid) == target) {
    			start = mid;
    		} else if (A.get(mid) < target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if (A.get(end) == target) {
    		result.set(1, end);
    	} else if (A.get(start) == target) {
    		result.set(1, start);
    	} else {
    		result.set(0, -1);
    		result.set(1, -1);
    		return result;
    	}
    	
    	return result;
    }
}
