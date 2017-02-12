package lint.ladder4.BFS;

/**
 * Created by xuan on 1/27/17.
 */
import common.datastructure.UndirectedGraphNode;
import java.util.ArrayList;
import java.util.Map;


public class SearchGraphNode {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        return null;
    }

    /*
    Given a undirected graph, a node and a target, return the nearest node with given node which value is target, return NULL if can't find.
There is hash mapping about nodes and their values.

 Notice

It's guaranteed there is only one available solution

Have you met this question in a real interview? Yes
Example
2------3  5
 \     |  |
  \    |  |
   \   |  |
    \  |  |
      1 --4
Give a node 1, target is 50

there a hash named values which is [3,4,10,50,50], represent:
Value of node 1 is 3
Value of node 2 is 4
Value of node 3 is 10
Value of node 4 is 50
Value of node 5 is 50

Return node 4
     */
}
