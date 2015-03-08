

import java.util.Arrays;

public class Solution {
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
}
