package lint.ladder4.BFS;

import java.util.Stack;

/**
 * Created by xuan on 1/25/17.
 */

public class NumberOfIslands {
    class Position {
        int x; int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (null == grid) {
            return 0;
        }
        int n = grid.length;
        if (0 == n) {
            return 0;
        }
        int m = grid[0].length;
        if (0 == m) {
            return 0;
        }

        Stack<Position> st = new Stack<>();
        int rst = 0;
        int[][] dir ={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] visited = new int[n][m];
        for (int i= 0; i<n; i++) {
            for (int j = 0; j< m; j++) {
                visited[i][j] = 0;
                st.add(new Position(i, j));
            }
        }
        while (!st.isEmpty()) {
            Position head = st.pop();
            if (0 == visited[head.x][head.y]) {
                rst++;
                //find all neighbours
                int x=0, y=0;
                for (int k =0; k < 4; k++) {
                    x = head.x + dir[k][0];
                    y = head.y + dir[k][0];
                }
                if (x>=0 && y>=0 && x<n && x<m && grid[x][y] && visited[x][y] ==0 ){

                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
//        NumberOfIslands ni = new NumberOfIslands();
//        boolean[][] grid = {{true, true, false, false, false},
//                            {false, true, false, false, true},
//                            {false, false, false, true, true},
//                            {false, false, false, false, false},
//                            {false, false, false, false, true}};
//
//        System.out.println(ni);
        int[][] a = new int[2][3];
        for (int i=0; i<2; i++) {
            for (int j=0; j<3; j++) {
                a[i][j] = 1;
            }
        }
        int n = a.length;
        int m = a[0].length;
        System.out.println(n);
        System.out.println(m);

    }
}
/*
Given a boolean 2D matrix, find the number of islands.

 Notice

0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Have you met this question in a real interview? Yes
Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.
 */