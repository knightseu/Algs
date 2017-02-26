package lint.ladder8;

/**
 * Created by xuanlin on 2/25/17.
 *
 * http://www.lintcode.com/en/problem/high-five/
 */
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class HighFive {
    class Record {
       public int id, score;
       public Record(int id, int score){
           this.id = id;
           this.score = score;
       }
    }

    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> answer = new HashMap<Integer, Double>();
        Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();

        for (Record r : results) {
            if (!hash.containsKey(r.id)){
                hash.put(r.id, new ArrayList<Integer>());
            }

            if (hash.get(r.id).size() < 5) {
                hash.get(r.id).add(r.score);
            } else {
                int index = 0;
                for (int i = 1; i < 5; ++i)
                    if (hash.get(r.id).get(i) < hash.get(r.id).get(index))
                        index = i;
                if (hash.get(r.id).get(index) < r.score)
                    hash.get(r.id).set(index, r.score);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()) {
            int id = entry.getKey();
            List<Integer> scores = entry.getValue();
            double average = 0;
            for (int i = 0; i < 5; ++i)
                average += scores.get(i);
            average /= 5.0;
            answer.put(id, average);
        }
        return answer;
    }


}
/*
There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.

Have you met this question in a real interview? Yes
Example
Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

Return
 */