/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?

1. 转对数：n=4^i，i=log4(n)，i=logb(4)/logb(n)，java中可以【用%1来获得i的小数部分】，判断是否为0，为0即i为整数。
​2. 与运算：由于偶数的二进制必为0000…00100…00的形式，故可将其与该数-1（0000…011…11）进行与运算，结果为1，排除了奇数；
           又由于4的幂次的二进制（0000…00100…00），在1的右边有偶数个0，故可与0x55555555（1010101010101010101010101010101）进行与运算，结果为该数本身，排除了偶数中非4的幂次。

*/



public class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (Math.log10(n) / Math.log10(4)) % 1 == 0;
    }
}


class Solution {
    public boolean isPowerOfFour(int n) {
         return n > 0 && ((n & (n-1)) == 0) && (n & 0x55555555) != 0;
    }
}