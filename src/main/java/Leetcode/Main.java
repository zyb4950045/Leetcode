package Leetcode;

/**
 * Created by zero on 2017/9/18.
 */
class Solution {
    private boolean inside(int i, int j, int R, int C) {
        if (i < R && i >= 0 && j < C && j >= 0) {
            return true;
        }
        return false;
    }
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int t = 0, n = R * C;
        int[][] res = new int[n][2];
        int[][] dir = new int[][]{{0,1},{1,0}, {0, -1}, {-1, 0}};
        int step = 0;
        res[t][0] = r0;
        res[t++][1] = c0;
        while (t < n) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) step++;
                for (int j = 0; j < step; j++) {
                    r0 += dir[i][0];
                    c0 += dir[i][1];
                    if (inside(r0, c0, R, C)) {
                        res[t][0] = r0;
                        res[t++][1] = c0;
                    }
                }
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        Solution solution = new Solution();
    }
}
