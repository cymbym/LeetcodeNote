/*
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
Example 2:
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
Example 3:
Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.
Example 4:
Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.

1.辗转相除法，挨个判断是否连续不一样。若不一样直接报错。
2.二进制神解法：return ((n + (n >> 1) + 1) & (n + (n >> 1))) == 0;
    比如n是10101，那么n>>1就是1010，二者相加就是11111，再加1就是100000，二者相‘与’就是0。
*/


class Solution {
    public boolean hasAlternatingBits(int n) {
        int remind = n % 2;
        n /= 2;
        while (n != 0) {
            int temp = n % 2;
            if (temp == remind) return false;
            n /= 2;
            remind = temp;
        }
        return true;
    }
}