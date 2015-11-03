package lint.ladder1.optional;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * Given a list of numbers that may has duplicate numbers, return all possible subsets

Have you met this question in a real interview? Yes
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Note
Each element in a subset must be in non-descending order.

The ordering between two subsets is free.

The solution set must not contain duplicate subsets.

 * @author xuanlin
 *
 */
public class SubsetsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsetsDup(ArrayList<Integer> S) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	if (S == null || S.size() == 0) {
    		return result;
    	}
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Collections.sort(S);
    	
    	helper(result, list, S, 0);
    	
    	return result;
    	
    }
    
    /**
     * 
     * @param result All results.
     * @param list currently being processed
     * @param S original array after sorted
     * @param pos current position being processed.
     */
    private static void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> S, int pos) {
       result.add(new ArrayList<Integer>(list));
       for (int i = pos; i < S.size(); i++) {
    	   if (i != pos && S.get(i) == S.get(i - 1)) {
    		   continue;
    	   }
    	   list.add(S.get(i));
    	   helper(result, list, S, i + 1);
    	   list.remove(list.size() - 1);
       }
    }

}
