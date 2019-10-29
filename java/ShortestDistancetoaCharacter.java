/*
Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 

Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.


1.我的解法：挨个遍历。  
*/

class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] SC = S.toCharArray();
        int[] res = new int[SC.length];
        for (int i = 0; i < SC.length; i ++) {
            int j = 0;
            while (i - j >= 0 || i + j < SC.length) {
                if (i - j >= 0 && SC[i - j] == C ) {
                    res[i] = j;
                    break;
                }
                if (i + j < SC.length && SC[i + j] == C ) {
                    res[i] = j;
                    break;
                }
                j ++;
            }
        }
        return res;
    }
}