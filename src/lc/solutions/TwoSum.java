package lc.solutions;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	//pointer version
	public int[] twoSum(int[] numbers, int target) {
        int [] num = numbers.clone();
        int [] result = new int[2];
        Arrays.sort(num);
        int length = num.length;
        int left = 0, right = length -1;
        int sum =0, count = 0;
        while (left <right) {
            sum = num[left] + num[right];
            if (sum == target) {
                for (int i=0; i<length; i++)
                {
                    if (numbers[i] ==num[left]) {
                        result[count++] = i+1;
                    }
                    else if (numbers[i]==num[right]) {
                        result[count++] = i+1;
                    }
                    if (count == 2) break;
                }
                break;
            }
            else if (sum < target) {
                left++;
            }
            else if (sum > target) {
                right--;
            }
        }
        return result;
    }
	
	//hash map
	public int[] twoSum2(int[] numbers, int target) {
	    if ((numbers ==null) || (numbers.length <2)) return null;
	    int []rst = new int[2];
	    HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
	    for (int i=0; i<numbers.length; i++) hs.put(numbers[i], i+1);
	    for (int i=0; i<numbers.length; i++) {
	    	if (hs.containsKey(target - numbers[i])) {
	    		int index1= i+1;
	    		int index2= hs.get(target - numbers[i]);
	    		if (index1 == index2) continue;
	    		rst[0] = index1;
	    		rst[1] =  index2;
	    		return rst;
	    	}
	    }
	    return rst;
	
	}
}
