package lc.solutions;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *  Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. 
 */
public class LC047_PermutationII {
	
	 public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        if(num == null || num.length == 0)
	            return result;
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        int[] visited = new int[num.length];
	        
	        Arrays.sort(num);
	        helper(result, list, visited, num);
	        return result;
	    }
	    
	    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] visited, int[] num) {
	        if(list.size() == num.length) {
	            result.add(new ArrayList<Integer>(list));
	            return;
	        }
	        
	        for(int i = 0; i < num.length; i++) {
	            if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)){
	                continue;
	            }
	            visited[i] = 1;
	            list.add(num[i]);
	            helper(result, list, visited, num);
	            list.remove(list.size() - 1);
	            visited[i] = 0;
	        }
	    }    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
