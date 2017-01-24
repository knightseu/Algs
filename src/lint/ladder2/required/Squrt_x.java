package lint.ladder2.required;

/**
 * Created by xuan on 1/23/17.
 */
public class Squrt_x {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x == 0 || x== 1) {
            return x;
        }
        int begin = 1;
        int end = x;
        while (begin + 1 < end) {
            int mid = (begin + end) / 2;
            int y = x/mid;
            if (y == mid) {
                return mid;
            }
            else if (y > mid) {
                begin = mid;
            }
            else {
                end = mid;
            }
        }
        return begin;
    }
}

/*
Implement int sqrt(int x).

Compute and return the square root of x.

Have you met this question in a real interview? Yes
Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3

Challenge
O(log(x))
 */
