package Leetcode;

import java.util.Arrays;

/**
 * Created by zero on 2017/9/18.
 */
class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A.length == 1) return A[0][0];
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            dp[0][i] = A[0][i];
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                } else if (j == A.length - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + A[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]), dp[i -
                            1][j])  +
                            A[i][j];
                }
            }
        }
        //System.out.println(Arrays.toString(dp[A.length - 1]));
        return Arrays.stream(dp[A.length - 1]).min().getAsInt();
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        int[][] array = new int[][]{{-84,-36,2},{87,-79,10},{42,10,63}};
        Solution solution = new Solution();
        System.out.println(solution.minFallingPathSum(array));
    }
}
