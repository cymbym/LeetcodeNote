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