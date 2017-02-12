package lint.ladder4.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xuan on 1/25/17.
 */
public class ZombieInMatrix {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        if (null == grid) {
            return -1;
        }
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }

        Queue<Position> queue = new LinkedList<Position>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Position(i, j));
                }
            }
        }

        int[][] direction ={{0,1},{1,0},{-1, 0},{0, -1}};
        int days = 0;

        while (! queue.isEmpty()) {
            days ++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position head = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int deadX = head.x + direction[k][0];
                    int deadY = head.y + direction[k][1];
                    if (deadX >= 0 && deadY >= 0 && deadX < n && deadY < m && grid[deadX][deadY] == 0) {
                        grid[deadX][deadY] = 1;
                        queue.offer(new Position(deadX, deadY));
                    }
                }
            }


        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }

        return days-1;

    }
    public static void main(String[] args) {
        ZombieInMatrix zb = new ZombieInMatrix();
        //int [][] grid = {{0,0,0},{0,0,0},{0,0,1}};
        int [][] grid = {{0,1,2,0,0},{1,0,0,2,1},{0,1,0,0,0}};
        int n = zb.zombie(grid);
        System.out.println(n);
    }

    public static void printArray(int [][]a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println(";");
        }
    }

}

class Position {
    int x, y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/*
Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall. How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.

Example
Given a matrix:

0 1 2 0 0
1 0 0 2 1
0 1 0 0 0
return 2
 */