package lint.ladder7;

/**
 * Created by xuanlin on 2/25/17.
 */
public class PartitionArray {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        //write your code here
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] < k) {
                left++;
            }
            while (left <= right && nums[right] >= k) {
                right--;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }
}
// 注意， 1.left<=right
//       2.nums[left]<k, nums[right]>=k
//       3.交换完，left++. right--