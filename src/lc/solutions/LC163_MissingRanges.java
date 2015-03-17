package lc.solutions;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

 */
public class LC163_MissingRanges {
/*
 * 分析：只要沿着区间lower扫一次即可。我们维持一个循环不变式： 目前[lower..upper]是不确定有没有在数组里出现的。A[]中小于lower的都已经决定好了。

于是有三种情况：

（1） A【i】 < lower, 因为小于lower的都考虑过了，所以A【i】这个数不影响结果。

（2） A【i】 == lower, 显然lower = lower + 1,继续考虑。

（3） A【i】 > lower， 这说明[lower..A【i】 - 1]是缺失的区间。然后我们输出lower..A【i】 - 1，然后lower = A【i】 + 1。

三种情况下，都能维持我们的循环不变式。写出的代码简短、清晰易懂，更容易考虑边界条件（第一个，最后一个等）。

我觉得循环不变式，可以简化问题，请仔细理解循环不变式的思想。
 */
	
	public List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> ranges = new ArrayList<String>();
        int prev = start - 1;
        for (int i=0; i<=vals.length; ++i) {
            int curr = (i==vals.length) ? end + 1 : vals[i];
            if ( curr-prev>=2 ) {
                ranges.add(getRange(prev+1, curr-1));
            }
            prev = curr;
        }
        return ranges;
    }
 
    private String getRange(int from, int to) {
        return (from==to) ? String.valueOf(from) : from + "->" + to;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
