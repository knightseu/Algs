package lint.Microsoft;

/**
 * Created by xuanlin on 2/23/17.
 */
class Direction {
    //helper for direction
    private static int DOWN = 0;
    private static int RIGHT = 1;
    private static int LEFT = 2;
    private static int UP = 3;

    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, 1, -1, 0};

    public static int turn(int direction) {
        if (DOWN == direction) {
            return LEFT;
        } else if (RIGHT == direction) {
            return DOWN;
        } else if (LEFT == direction) {
            return UP;
        } else if (UP == direction) {
            return RIGHT;
        }
        return -1;
    }

    public static int[] move(int[] cursor, int direction) {
        int[] nextCursor = new int[2];
        nextCursor[0] = cursor[0] + dx[direction];
        nextCursor[1] = cursor[1] + dy[direction];
        return nextCursor;
    }
}

public class SpiralMatrix {
    public static void printSpiral(int [][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return;
        }
        if (null == matrix[0] || matrix[0].length == 0) {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int [] cursor = new int[] {0, 0};

        for (int i = 0; i < row * col; i++) {
            //print current
            System.out.print(matrix[cursor[0]][cursor[1]]);


        }
    }

    // o(1) space, do not change matrix
    public static void printSpiral2(int [][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return;
        }
        if (null == matrix[0] || matrix[0].length == 0) {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int count = 0;
        while (2*count < row && 2*count <col) { //TODO

            //right
            for (int i = count; i < col-count; i++) {
                System.out.print(matrix[count][i]);
            }

            //down
            for (int i = count+1; i < row-count; i++) {
                System.out.print(matrix[i][col-count-1]);
            }

            //check if only 1 row or 1 col remains
            if (row - 2*count == 1 || col - 2*count == 1) {
                break;
            }

            //left
            for (int i = col-count-2; i >= count; i--) {
                System.out.print(matrix[row-count-1][i]);
            }

            //up
            for (int i = row-count-2; i >= count+1; i--) {
                System.out.print(matrix[i][count]);
            }

            count++;
        }

    }



    public static void main(String[] args) {
        int[][] m1 = new int[][] { {1} };
        int[][] m2 = new int[][] { {1,2,3} };
        int[][] m3 = new int[][] { {1,2,3,4}, {5,6,7,8} };
        int[][] m4 = new int[][] { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };
        int[][] m5 = new int[][] { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16} };

        //printMatrix(m3);
        printSpiral2(m5);
    }

    public static void printMatrix(int [][] matrix) {
        for (int i=0; i< matrix.length; i++) {
            for (int j = 0; j<matrix[0].length; j++ ) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}


