package lc.solutions;

/*
 *  Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 

 */

import java.util.ArrayList;

public class LC046_Permutations {

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return rst; 
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rst, list, num);
        return rst;
   }
   
   public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int[] num){
       if(list.size() == num.length) {
           rst.add(new ArrayList<Integer>(list));
           return;
       }
       
       for(int i = 0; i<num.length; i++){
           if(list.contains(num[i])){
               continue;
           }
           list.add(num[i]);
           helper(rst, list, num);
           list.remove(list.size() - 1);
       }
       
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
