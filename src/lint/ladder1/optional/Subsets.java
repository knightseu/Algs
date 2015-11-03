package lint.ladder1.optional;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Given a set of distinct integers, return all possible subsets.

Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Note
Elements in a subset must be in non-descending order.

The solution set must not contain duplicate subsets.
 * 
 * @author xuanlin
 *
 */
public class Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
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
    	   list.add(S.get(i));
    	   helper(result, list, S, i + 1);
    	   list.remove(list.size() - 1);
       }
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(0);
    	subsets(list);

	}
}
