package lint;

/**
 * Created by xuanlin on 17/2/19.
 */
public class StoneGame {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        return -1;
    }
}


/*
There is a stone game.At the beginning of the game the player picks n piles of stones in a line.

The goal is to merge the stones in one pile observing the following rules:

At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.

Have you met this question in a real interview? Yes
Example
For [4, 1, 1, 4], in the best solution, the total score is 18:

1. Merge second and third piles => [4, 2, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10
Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43
 */

/*
State:
dp[i][j]表示把第i到第j个石子合并到一起的最小花费
Function:
预处理sum[i,j]表示i到j所有石子价值和
dp[i][j] = min(dp[i][k]+dp[k+1][j]+sum[i,j]) 对于所有k属于{i,j}
Intialize:
for each i
dp[i][i] = 0
Answer:
dp[0][n-1]

 */