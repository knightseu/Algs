package lint.ladder5;

/**
 * Created by xuan on 1/31/17.
 */
import java.util.*;


public class WordLadder {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (null == dict) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        Queue<String> queue = new LinkedList<String>();
        HashSet<String> hash = new HashSet<String>();
        queue.offer(start);
        hash.add(start);

        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length ++;
            for (int i=0; i< size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }

        return 0;
    }


    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }

    //////////////
    ///
    //
    ///
    //////////////

    private ArrayList<String> getNextWords2(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (char c='a'; c<='z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextword = replace2(word, i, c);
                if (dict.contains(nextword)) {
                    nextWords.add(nextword);
                }
            }
        }
        return  null;
    }

    private String replace2(String word, int pos, char c) {
        char [] chars = word.toCharArray();
        chars[pos] = c;
        return new String(chars);
    }

    public int ladderLength2(String start, String end, Set<String> dict) {
        if (null == dict) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        int length = 1;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> hash = new HashSet<>();
        queue.offer(start);
        hash.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord == end) {
                        return length;
                    }
                    queue.offer(nextWord);
                    hash.add(nextWord);
                }
            }
        }

        return 0;
    }
}


/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
 Notice

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Have you met this question in a real interview? Yes
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
 */