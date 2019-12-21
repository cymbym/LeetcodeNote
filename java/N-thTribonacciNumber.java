/*
The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
 

Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

1.三个数的斐波那契数列，用数组存储+遍历即可。
*/

class Solution {
    public int tribonacci(int n) {
        int[] res = new int[38];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        if (n < 3) return res[n];
        else {
            int inx = 3;
            while(inx <= n) {
                res[inx] = res[inx - 1] + res[inx - 2] + res[inx - 3];
                inx ++;
            }
            return res[n];
        }
    }
}