/*
X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.
  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation.
 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other,
 and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation: 
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
Note:

N  will be in range [1, 10000].

1.注意只是翻转对应位置的数，如15变成12，18依然是18，不是21和81。
*/

class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 2; i <= N; i ++) {
            boolean flag = false;
            int num = i;
            while (num != 0) {
                int tmp = num % 10;
                if (tmp == 2 || tmp == 5 || tmp == 6 || tmp == 9) flag = true;
                else if (tmp == 3 || tmp == 4 || tmp == 7) {
                    flag = false;
                    break;
                }
                num /= 10;
            }
            if (flag) res ++;
        }
        return res;
    }
}