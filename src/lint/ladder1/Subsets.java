package lint.ladder1;

/**
 * Created by xuan on 1/29/17.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int [] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        subsetHelper(nums, 0, new ArrayList<Integer>(), results);

        return results;
    }

    private void subsetHelper(int[] nums,
                              int startIndex,
                              ArrayList<Integer> curRst,
                              ArrayList<ArrayList<Integer>> results) {
        // add a deep copy
        results.add(new ArrayList<Integer>(curRst));

        for (int i = startIndex; i < nums.length; i++) {
            curRst.add(nums[i]);
            subsetHelper(nums, i + 1, curRst, results);
            curRst.remove(curRst.size() - 1);
        }

    }

    public static void main(String[] args)
    {
        int[] a = {2, 1, 3};
        Subsets sb = new Subsets();
        ArrayList<ArrayList<Integer>> rst  = sb.subsets(a);
        for (ArrayList<Integer> x: rst) {

            System.out.println(x);
        }
    }
}
