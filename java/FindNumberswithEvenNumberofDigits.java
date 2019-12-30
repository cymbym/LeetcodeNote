/*
Given an integer n, return any array containing n unique integers such that they add up to 0.

 

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]
 

Constraints:

1 <= n <= 1000

1.题意：拼凑和为0的数，分n是否为1，以及n为奇数还是偶数。
*/

class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int inx = 1;
        res[n / 2] = 0;
        if (n == 1) return res;
        else {
            while (inx < n / 2) {
                res[n / 2 + inx] = inx;
                res[n / 2 - inx] = - inx;
                inx += 1;
            }
            if (n % 2 == 1) {
                res[n / 2 + inx] = inx;
                res[n / 2 - inx] = - inx;
            } else {
                res[0] = - inx;
                res[n / 2 + inx - 1] = inx + inx - 1;
            }
            return res;
        }
    }
}