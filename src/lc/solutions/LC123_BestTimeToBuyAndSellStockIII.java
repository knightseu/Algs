package lc.solutions;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i. 
 * Design an algorithm to find the maximum profit. 
 * You may complete at most two transactions.
 *  Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). 
 */
/*
 * 和前两道题比起来的话，这道题最难了，因为限制了交易次数。
解决问题的途径我想出来的是：既然最多只能完成两笔交易，而且交易之间没有重叠，那么就divide and conquer。
设i从0到n-1，那么针对每一个i，看看在prices的子序列[0,…,i][i,…,n-1]上分别取得的最大利润（第一题）即可。
这样初步一算，时间复杂度是O(n2)。


改进：
改进的方法就是动态规划了，那就是第一步扫描，先计算出子序列[0,…,i]中的最大利润，用一个数组保存下来，那么时间是O(n)。
第二步是逆向扫描，计算子序列[i,…,n-1]上的最大利润，这一步同时就能结合上一步的结果计算最终的最大利润了，这一步也是O(n)。
所以最后算法的复杂度就是O(n)的。
 */
public class LC123_BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        // DP from left to right;
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        //DP from right to left;
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            profit = Math.max(left[i] + right[i], profit);  
        }

        return profit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
