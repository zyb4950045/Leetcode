//CHECKSTYLE:OFF
package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zero on 2017/9/18.
 */
class Solution {
    private int[] vis1 = new int[27];
    private int[] vis2 = new int[27];
    private boolean isSame(String pattern, String word) {
        if (pattern.length() != word.length()) return false;
        //System.out.println(word);
        for (int i = 0; i < word.length(); i++) {
            int pos1 = word.charAt(i) - 96;
            int pos2 = pattern.charAt(i) - 96;
            System.out.println(vis1[pos1] + "," + vis2[pos2]);
            if (vis1[pos1] == 0 && vis2[pos2] == 0) {
                vis1[pos1] = pos2;
                vis2[pos2] = pos1;
            } else if (vis1[pos1] > 0 && vis2[pos2] > 0 && vis1[pos1] == pos2) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (words == null || words.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isSame(pattern, word)){
                res.add(word);
            }
            Arrays.fill(vis1, 0);
            Arrays.fill(vis2, 0);
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        Solution solution = new Solution();
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "bba";
        List<String> res = solution.findAndReplacePattern(words, pattern);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
