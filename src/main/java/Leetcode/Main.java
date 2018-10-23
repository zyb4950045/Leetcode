//CHECKSTYLE:OFF
package Leetcode;

/**
 * Created by zero on 2017/9/18.
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        char[] array = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (array[i] == array[j]) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (i == j - 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        Solution solution = new Solution();
        String str = "abcdcefhab";
        System.out.println(solution.longestPalindromeSubseq(str));
    }
}
