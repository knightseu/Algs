package lint.ad_ladder1;

import java.lang.annotation.Target;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xuan on 1/21/17.
 */
public class KthInArrays {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int kthInArrays(int[][] arrays, int k) {
        // Write your code here

        PriorityQueue<Targets> pq = new PriorityQueue<Targets>();
        int m =  arrays.length;
        int n = arrays[0].length;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                pq.offer(new Targets(arrays[i][j]));
            }
        }
        for (int h = 0; h<k-1; h++) {
            pq.poll();
        }
        return pq.poll().val;
    }




    class Targets implements Comparable<Targets> {
        int val;
        public Targets(int val) {
            this.val = val;
        }


        public int compareTo(Targets that) {
            return that.val - this.val;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello Xuan!");
        int[][] a = {{9,3,2,4,7},{1,2,3,4,8}};
        KthInArrays b = new KthInArrays();
        System.out.print(b.kthInArrays(a, 3));
    }

}


