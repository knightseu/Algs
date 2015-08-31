package lint.ladder2.required;

/**
 * 
 * Merge Sorted Array

34% Accepted
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Have you met this question in a real interview? Yes
Example
A = [1, 2, 3, empty, empty], B = [4, 5]

After merge, A will be filled as [1, 2, 3, 4, 5]

Note
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

 * @author xuanlin
 *
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m + n -1;
        int a = m - 1;
        int b = n - 1;
        
        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[i] = A[a];
                a--;
            } else {
                A[i] = B[b];
                b--;
            }
            i--;
        }
        while (b >= 0) {
            A[i] = B[b];
            i--;
            b--;
        }
    }

}
