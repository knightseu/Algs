package lint.Amazon;

import java.util.Map;

/**
 * Created by xuanlin on 2/21/17.
 * 613
 * http://www.lintcode.com/en/problem/high-five/
 * http://www.jiuzhang.com/solutions/high-five/
 */
class Record {
    public int id, score;
    public Record(int id, int score) {
        this.id = id;
        this.score = score;
    }
}
public class HighFive {
    public Map<Integer, Double> highFive(Record[] results) {
        return null;
    }
}


/*
There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.

Have you met this question in a real interview? Yes
Example
Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

Return
 */