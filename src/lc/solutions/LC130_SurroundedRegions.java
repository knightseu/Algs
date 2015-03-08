package lc.solutions;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

 */
public class LC130_SurroundedRegions {
	/*
	 *  这题题意也略显含糊，实际上就是要将所有以O组成、但不连通到网格边缘的区域变为X。所以我们可以先在四边上寻找连通到边缘的区域，将它们的O都变成Y。剩余的所有O一定无法连通到边缘，所以可以全部变为X。最后再将所有Y变回O。

	 */
    private static Queue<Integer> queue = null;
    private static char[][] board;
    private static int rows = 0;
    private static int cols = 0;

    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (board.length == 0 || board[0].length == 0) return;
        queue = new LinkedList<Integer>();
        board = board;
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) { // **important**
            enqueue(i, 0);
            enqueue(i, cols - 1);
        }

        for (int j = 1; j < cols - 1; j++) { // **important**
            enqueue(0, j);
            enqueue(rows - 1, j);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / cols,
                y = cur % cols;

            if (board[x][y] == 'O') {
                board[x][y] = 'D';
            }

            enqueue(x - 1, y);
            enqueue(x + 1, y);
            enqueue(x, y - 1);
            enqueue(x, y + 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'D') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        queue = null;
        board = null;
        rows = 0;
        cols = 0;
    }

    public static void enqueue(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O'){  
            queue.offer(x * cols + y);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
