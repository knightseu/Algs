package lint.Microsoft;

/**
 * Created by xuanlin on 2/23/17.
 */
public class BinarySearch {
    public static int findPosition(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end-start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] <  target) {
                start = mid;
            }
            else if (nums[mid] > target) {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }
        return 0;
    }


    public static void main(String[] args) {
        int [] a  ={1,2,3,4,5,6,7,8,9};
        System.out.print(findPosition(a, 3));

    }
}
