package lc.solutions;

import java.util.ArrayList;
import java.util.Arrays;
/*
 *  Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */

public class LC090_SubsetsII {
	public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(num == null || num.length ==0) {
            return result;
        }
        Arrays.sort(num);
        subsetsHelper(result, list, num, 0);

        return result;
    }

    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int[] num, int pos) {

        result.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < num.length; i++) {
            if ( i != pos && num[i] == num[i - 1]) {
                continue;
            }    
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
