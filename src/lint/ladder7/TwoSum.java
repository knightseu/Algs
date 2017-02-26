package lint.ladder7;

/**
 * Created by xuanlin on 2/25/17.
 * 607
 * http://www.lintcode.com/en/problem/two-sum-data-structure-design/
 */

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TwoSum {
    private List<Integer>   list = null;
    private HashMap<Integer, Integer> map = null;

    TwoSum(){
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number)+1);
        }
        else {
            map.put(number, 1);
            list.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for (int i=0; i<list.size(); i++) {
            int num1 = list.get(i);
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) ||
                    (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);

/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Have you met this question in a real interview? Yes
Example
add(1); add(3); add(5);
find(4) // return true
find(7) // return false
 */