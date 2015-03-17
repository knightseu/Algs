package lc.solutions;

import java.util.HashMap;
import java.util.Map;

/*
 *  Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
For example,

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
 */
public class LC170_TwoSumIII {
	Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
public void add(int number) {
if (dict.containsKey(number)) {
dict.put(number, dict.get(number) + 1);
} else {
dict.put(number, 1);
}
}
 
public boolean find(int value) {
for (Integer key : dict.keySet()) {
if (value - key == key) {
if (dict.get(key) >= 2) {
return true;
}
} else if (dict.containsKey(value - key)) {
return true;
}
}
return false;
} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
