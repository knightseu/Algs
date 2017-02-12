package lint.ladder5;

/**
 * Created by xuan on 1/31/17.
 */
public class ExpressionExpand {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here

        int number = 0;
        for (char c: s.toCharArray()) {

        }
        return  null;
    }
}

/*
Given an expression s includes numbers, letters and brackets. Number represents the number of repetitions inside the brackets(can be a string or another expression)．Please expand expression to be a string.

Have you met this question in a real interview? Yes
Example
s = abc3[a] return abcaaa
s = 3[abc] return abcabcabc
s = 4[ac]dy, return acacacacdy
s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz


 */