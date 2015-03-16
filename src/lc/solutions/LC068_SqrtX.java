package lc.solutions;
/*
 * Implement int sqrt(int x).

Compute and return the square root of x.
 */
public class LC068_SqrtX {
	
	 public int sqrt(int x) {
	        long lo = 0;
	        long hi = x;

	        while (hi >= lo) {     
	            long mid = lo+(hi-lo)/2;
	            if (x < mid * mid) {
	                hi = mid-1;      // not hi = mid
	            } else {
	                lo = mid+1;  
	            }
	        }
	        return (int) hi;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
