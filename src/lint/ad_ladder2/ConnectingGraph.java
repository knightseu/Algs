package lint.ad_ladder2;

/**
 * Created by xuanlin on 3/2/17.
 * 589
 * http://www.lintcode.com/en/problem/connecting-graph/
 */
public class ConnectingGraph {
    private int[] father = null;

    private int find(int x) {
        if (father[x] == 0) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    public ConnectingGraph(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            father[i] = 0;
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b)
            father[root_a] = root_b;
    }

    public boolean  query(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        return root_a == root_b;
    }
}


/*
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), add an edge to connect node a and node b. 2.query(a, b)`, check if two nodes are connected

Have you met this question in a real interview? Yes
Example
5 // n = 5
query(1, 2) return false
connect(1, 2)
query(1, 3) return false
connect(2, 4)
query(1, 4) return true
 */