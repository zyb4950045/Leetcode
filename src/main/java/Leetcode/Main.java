//CHECKSTYLE:OFF
package Leetcode;

/**
 * Created by zero on 2017/9/18.
 */
class Solution {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) return 0;
        int ans = 0, left = 0, right = 0;
        for(char ch : S.toCharArray()) {
            if (ch == ')') {
                if (left == 0) {
                    ans++;
                } else {
                    left--;
                }
            } else {
                left++;
            }
        }
        return ans + left;
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        Solution solution = new Solution();
        String str = "((()))";
        System.out.println(solution.minAddToMakeValid(str));
    }
}
