package Leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zero on 2017/9/18.
 */
class Solution {
    private static final int LENGTH = 1005;
    int[] vis = new int[LENGTH];
    private void dfs(int i, List<List<Integer>> rooms) {
        vis[i] = 1;
        for (Integer key : rooms.get(i)) {
            if (vis[key] == 0) {
                dfs(key, rooms);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 1) {
            return true;
        }
        dfs(0, rooms);
        int cnt = Arrays.stream(vis).filter(i -> i > 0).sum();
        return cnt == rooms.size();
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        int[] array = new int[]{1,2,3,4};
        Solution solution = new Solution();
        System.out.println(solution);
    }
}
