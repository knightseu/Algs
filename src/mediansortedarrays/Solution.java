package mediansortedarrays;

public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {  
        int m = A.length;  
        int n = B.length;  
        int total = m + n;  
        if ((total & 0x01) != 0) { //odd 
            return find_kth(A, 0, m, B, 0, n, total / 2 + 1);  
        } else {  //even
            return (find_kth(A, 0, m, B, 0, n, total / 2) + find_kth(A, 0, m, B, 0, n,  
                    total / 2 + 1)) / 2.0;  
        }  
    }  
  
    public double find_kth(int A[], int aStart, int m, int B[], int bStart, int n, int k) {
    	//make things easier if A is always smaller
    	if (m > n) {  
            return find_kth(B, bStart, n, A, aStart, m, k);  
        }  
    	
    	//base 1
        if (m == 0) {  
            return B[k - 1];  
        }  
        
        //base 2
        if (k == 1) {  
            return Math.min(A[aStart], B[bStart]);  
        }  
        
        //general
        int pa = Math.min(k/2, m);
        int pb = k - pa; 
        
        if (A[aStart + pa -1] == B[bStart + pb-1]) {
            return A[pa-1];	
        }
        else if (A[aStart + pa -1] < B[bStart + pb-1]) {
            return find_kth(A, aStart + pa, m-pa, B, bStart, n, k-pa);      	
        }
        else {
        	return find_kth(A, aStart, m, B, bStart + pb, n-pb, k-pb);
        }
    }
    /*
        
  
        int pa = Math.min(k / 2, m);  
        int pb = k - pa;  
        if (A[pa - 1] < B[pb - 1]) {  
            return find_kth(Arrays.copyOfRange(A, pa, A.length), m - pa, B, n,  
                    k - pa);  
        } else if (A[pa - 1] > B[pb - 1]) {  
            return find_kth(A, m, Arrays.copyOfRange(B, pb, B.length), n - pb,  
                    k - pb);  
        } else {  
            return A[pa - 1];  
        }  
    }  
  */
    public static void main(String[] args) {  
        int[] A = { 1, 2 };  
        int[] B = { 1, 2 };  
        Solution slt = new Solution();  
        double result = slt.findMedianSortedArrays(A, B);  
        System.out.println(result);  
    }  
}
