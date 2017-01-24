package lint.ad_ladder1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by xuan on 1/22/17.
 */
public class KthSmallestSum {

    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        IntVal p = new IntVal(0, 0, A[0]+B[0]);
        IntVal nextP = null;
        int nextX, nextY;

        //
        HashSet<IntVal> isvisited = new HashSet<IntVal>();

        //create a min Heap and put first element
        PriorityQueue<IntVal> pq = new PriorityQueue<IntVal>();

        pq.offer(p);

        for (int i = 0; i < k - 1; i++) {
            p = pq.poll();
            System.out.println(p.val+"-"+p.x+","+p.y);
            for (int j = 0; j<2; j++) {
                nextX = p.x + dx[j];
                nextY = p.y + dy[j];
                nextP = new IntVal(nextX, nextY, 0);
                if (nextX< A.length && nextY < B.length && !isvisited.contains(nextP)) {
                    nextP.val = A[nextX] + B[nextY];
                    isvisited.add(nextP);
                    pq.offer(nextP);

                }
            }
        }
        return pq.poll().val;
    }


    class IntVal implements Comparable<IntVal> {
        int x;
        int y;
        int val;
        public IntVal(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(IntVal that) {
            return this.val - that.val;
        }

        @Override
        public int hashCode() {
            return x * 101 + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            } else if (!(obj instanceof IntVal)) {
                return false;
            }
            IntVal another = (IntVal) obj;
            return this.x == another.x && this.y == another.y;
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello Xuan!");
        int[] a = {1, 7, 11};
        int[] b = {2, 4, 6};
        KthSmallestSum A = new KthSmallestSum();
        System.out.print(A.kthSmallestSum(a, b, 8));
    }
}









/*
Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.

Have you met this question in a real interview? Yes
Example
Given [1, 7, 11] and [2, 4, 6].

For k = 3, return 7.

For k = 4, return 9.

For k = 8, return 15.

Challenge
Do it in either of the following time complexity:

O(k log min(n, m, k)). where n is the size of A, and m is the size of B.
O( (m + n) log maxValue). where maxValue is the max number in A and B.
 */