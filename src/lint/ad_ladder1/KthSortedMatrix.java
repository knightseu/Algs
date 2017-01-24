package lint.ad_ladder1;

/**
 * Created by xuan on 1/21/17.
 */

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSortedMatrix {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Tuple> minHeap = new PriorityQueue<Tuple>();
        for (int j = 0; j <= n-1; j++) {
            minHeap.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i< k-1; i++) {
            Tuple t =  minHeap.poll();
            if (t.x == m-1) continue;
            minHeap.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return minHeap.poll().val;
    }
    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
        }
    }
    /*
    public int kthSmallest(int[][] matrix, int k) {
        //dx, dy - control the direction
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};

        //m, n - dimension
        int n = matrix.length;
        int m = matrix[0].length;

        //helper
        HashSet<Pair> visited = new HashSet<Pair>();
        boolean[][] hash = new boolean[n][m];


        Queue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
        minHeap.add(new Pair(0, 0, matrix[0][0]));



        return 0;
    }
    */
    public static void main(String[] args) {
        System.out.println("Hello Xuan");
    }
}


class Pair {
    public int x, y, val;
    public Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.val - b.val;
    }
}

//public class Solution {
//    /**
//     * @param matrix: a matrix of integers
//     * @param k: an integer
//     * @return: the kth smallest number in the matrix
//     */
//    public int kthSmallest(int[][] matrix, int k) {
//        // write your code here
//        int[] dx = new int[]{0, 1};
//        int[] dy = new int[]{1, 0};
//        int n = matrix.length;
//        int m = matrix[0].length;
//        HashSet<Pair> visited = new HashSet<Pair>();
//        boolean[][] hash = new boolean[n][m];
//        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
//        minHeap.add(new Pair(0, 0, matrix[0][0]));
//
//        for(int i = 0; i < k - 1; i ++){
//            Pair cur = minHeap.poll();
//            for(int j = 0; j < 2; j ++){
//                int next_x = cur.x + dx[j];
//                int next_y = cur.y + dy[j];
//                Pair next_Pair = new Pair(next_x, next_y, 0);
//                if(next_x < n && next_y < m && !hash[next_x][next_y]){
//                    hash[next_x][next_y] = true;
//                    next_Pair.val = matrix[next_x][next_y];
//                    minHeap.add(next_Pair);
//                    visited.add(next_Pair);
//                }
//            }
//        }
//        return minHeap.peek().val;
//    }
//}
//
////  二分法
//class ResultType {
//    public int num;
//    public boolean exists;
//    public ResultType(boolean e, int n) {
//        exists = e;
//        num = n;
//    }
//}
//public class Solution {
//    /**
//     * @param matrix: a matrix of integers
//     * @param k: an integer
//     * @return: the kth smallest number in the matrix
//     */
//
//    public ResultType check(int value, int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        boolean exists = false;
//        int num = 0;
//        int i = n - 1, j = 0;
//        while (i >= 0 && j < m) {
//            if (matrix[i][j] == value)
//                exists = true;
//
//            if (matrix[i][j] <= value) {
//                num += i + 1;
//                j += 1;
//            } else {
//                i -= 1;
//            }
//        }
//
//        return new ResultType(exists, num);
//    }
//
//    public int kthSmallest(int[][] matrix, int k) {
//        // write your code here
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        int left = matrix[0][0];
//        int right = matrix[n - 1][m - 1];
//
//        // left + 1 < right
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            ResultType type = check(mid, matrix);
//            if (type.exists && type.num == k) {
//                return mid;
//            } else if (type.num < k) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return left;
//    }
//}