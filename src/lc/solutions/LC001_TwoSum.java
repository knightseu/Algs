package lc.solutions;
/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 
 */
public class LC001_TwoSum {
	 public int[] twoSum_hashmap(int[] numbers, int target) {
	    	if(numbers == null || numbers.length < 2) {
	    		return null;
	    	}
	        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
	        for(int i=0; i<numbers.length; i++){
	            hs.put(numbers[i], i+1);
	        }       
	        
	        int[] a = new int[2];
	        
	        for(int i=0; i<numbers.length ; i++){
	            if ( hs.containsKey( target - numbers[i] )){
	                int index1 = i+1;
	                int index2 = hs.get(target - numbers[i]);
	                if (index1 == index2){
	                    continue;
	                }
	                a[0] = index1;
	                a[1] = index2;
	                return a;
	            }
	        }
	        return a;
	    }
//Can’t use the sort method here, since the question asks for indexes.
 public int[] twoSum_pointer(int[] numbers, int target) {
	    	if(numbers == null || numbers.length < 2) {
	    		return null;
	    	}
	        Arrays.sort(numbers);
	        int left = 0;
	        int right = numbers.length - 1;
	        int[] rst = new int[2];
	        
	        while( left < right){
	            int sum = numbers[left] +  numbers[right];
	            if( sum == target){
	                rst[0] = left + 1;
	                rst[1] = right + 1;
	                break;
	            }else if( sum < target){
	                left++;
	            }else{
	                right--;
	            }
	        }
	        return rst;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
