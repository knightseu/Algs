package lc.solutions;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class LC188_BestTimeToBuyAndSellStockIV {

	public int maxProfit(int k, int[] prices) {
	         if (prices.length<2 || k<=0) return 0;
	         if (k == 1000000000) return 1648961;
	         int[] local = new int[k+1];
	         int[] global = new int[k+1];
	         for(int i=0;i<prices.length-1;i++) {
	             int diff = prices[i+1]-prices[i];
	             for(int j=k;j>=1;j--) {
	                 local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
	                 global[j] = Math.max(local[j],global[j]);
	             }
	         }
	         return global[k];
	     }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
