package lint.ladder1.optional;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * Given a list of numbers, return all possible permutations.

Have you met this question in a real interview? Yes
Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge
Do it without recursion.

 * @author xuanlin
 *
 */
public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	if (nums == null || nums.size() == 0) {
    		return result;
    	}
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Collections.sort(nums);
    	
    	helper(result, list, nums);
    	
    	return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> S) {
    	if (list.size() == S.size()) {
    		result.add(new ArrayList<Integer>(list));
    		return;
    	}
    	
        for (int i = 0; i < S.size(); i++) {
           if (list.contains(S.get(i))) {
        	   continue;
           }
     	   list.add(S.get(i));
     	   helper(result, list, S);
     	   list.remove(list.size() - 1);
        }
    }
     

}
