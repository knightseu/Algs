package lint.DIG;

/**
 * Created by xuanlin on 2/25/17.
 */
public class spiralPrint {
    public static void main(String[] args) {
        String s= "3;3;1 2 3 4 5 6 7 8 9";
            String[] input = s.split(";");
            if (null == input || input.length != 3) {
                return;
            }
            // parse n
            int n;
            try {
                n = Integer.parseInt(input[0]);
            } catch (NumberFormatException e) {
                return;
            }
            // parse m
            int m;
            try {
                m = Integer.parseInt(input[1]);
            } catch (NumberFormatException e) {
                return;
            }
            if (m == 0 || n == 0) {
                return;
            }

            // parse the rest
            String[] strs = input[2].split(" ");
            if (null == strs || strs.length != n*m) {
                return;
            }
            //System.out.println("------"+"n:" + n + "   m:"+m);
            String[][] arr = new String[n][m];
            int count = 0;

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    arr[i][j] = strs[count++];
                    //System.out.print(arr[i][j] + " ");
                }
                //System.out.println();
            }
            //System.out.println("~~~~~~~~~~~~");

            printSpiral(arr);

    }

    private static void printSpiral(String[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        //todo - some exit condition
        while (count*2 < rows && count*2 < cols) {
            //right
            for (int i=count; i<cols-count; i++) {
                printStr(matrix[count][i]);
            }

            //down
            for (int i=count+1; i<rows-count; i++) {
                printStr(matrix[i][cols-count-1]);
            }


            // take care of if only 1 col or 1 row left
            if (rows - 2*count == 1 || cols - 2*count ==1) {
                break;
            }

            //left
            for (int i=cols-count-2; i>=count; i--) {
                printStr(matrix[rows-count-1][i]);
            }

            //up
            for (int i = rows-count-2; i>=count+1; i--) {
                printStr(matrix[i][count]);
            }
        }
    }

    private static void printStr(String str) {
        System.out.print(str + " ");
    }
}
