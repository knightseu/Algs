package lint.ladder8;

/**
 * Created by xuanlin on 2/26/17.
 *
 * http://www.lintcode.com/en/problem/kth-largest-element-ii/
 */
import java.util.PriorityQueue;
public class KthLargestElementII {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            q.offer(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }
}
