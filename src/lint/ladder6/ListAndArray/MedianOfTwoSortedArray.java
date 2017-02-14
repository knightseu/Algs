package lint.ladder6.ListAndArray;

/**
 * Created by xuan on 2/14/17.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 != 0) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }
    }


    // find kth number
    private int findKth(int[] A, int aStart, int[] B, int bStart, int k) {
        return 0;
    }
}


/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.

Have you met this question in a real interview? Yes
Example
Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.

Given A=[1,2,3] and B=[4,5], the median is 3.
 */