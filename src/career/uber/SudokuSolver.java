package career.uber;

/**
 * Created by xuanlin on 3/11/17.
 */
public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public static boolean solve(char[][] board){
        for (int i=0; i<board.length-1; i++) {
            for (int j=0; j<board[0].length-1; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int k = 1; k<=9; k++) {
                    board[i][j] = (char) (k+ '0');
                    if (isValid(board, i, j) && solve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col) {
        //check row
        int[] hash = {0,0,0,0,0,0,0,0,0};
        for (int i=0; i<9; i++) {
            if (board[row][i] >'0' && board[row][i]<='9') {
                if (hash[board[row][i]-'0'] == 1) {
                    return false;
                }
                hash[board[row][i]-'0'] = 1;
            }

        }

        int[] hash2 = {0,0,0,0,0,0,0,0,0};
        //check col
        for (int i=0; i<9; i++) {
            if (board[i][col] >'0' && board[i][col]<='9') {
                if (hash2[board[i][col]-'0'] == 1) {
                    return false;
                }
                hash2[board[row][i]-'0'] = 1;
            }
        }

        int[] hash3 = {0,0,0,0,0,0,0,0,0};
        //check small board
        for (int i=0; i<9; i++) {
            int x = row/3*3+ i%3;
            int y = col/3*3 + i%3;
            if (board[x][y] > '0' && board[x][y] <= '9') {
                if (hash3[board[x][y] - '0'] == 1) {
                    return false;
                }
                hash3[board[x][y] - '0'] = 1;
            }
        }
        return true;
    }


    public static void main (String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);
    }
}
