package lc.sol2;

import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		permuteHelper(result, list, num);
		
		return result;
	}
	
	private void permuteHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num) {
		if (list.size() == num.length) {
			result.add(list);
		} else {
			for (int i = 0; i < num.length; i++) {
				if (list.contains(num[i])) {
					continue;
				}
				list.add(num[i]);
				permuteHelper(result, list, num);
				list.remove(list.size() - 1);
			}
		}
	}
}
