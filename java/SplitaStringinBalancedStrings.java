/*
Balanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.

 

Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
Example 4:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 

Constraints:

1 <= s.length <= 1000
s[i] = 'L' or 'R'

1.使用标记数，若出现L则自加1，若出现R则自减1，若标记数为0，则结果自加1。
*/

class Solution {
    public int balancedStringSplit(String s) {
        char[] c = s.toCharArray();
        int inx = 0;
        int flag = 0;
        int res = 0;
        while (inx < c.length) {
            if (c[inx ++] == 'L') flag ++;
            else flag --;
            if (flag == 0) res ++;
        }
        return res;
    }
}