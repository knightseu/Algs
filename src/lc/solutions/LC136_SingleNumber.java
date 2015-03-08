package lc.solutions;
/*
 * Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 */
public class LC136_SingleNumber {
	 public int singleNumber(int[] A) {
	        int x=0;
	 
	        for(int a: A){
	            x = x ^ a;
	        }
	 
	        return x;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
