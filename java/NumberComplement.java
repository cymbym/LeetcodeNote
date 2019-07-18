/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

1.我：进制转换。
2.最优解：移位+或1，得到num的位数，如101，得到111，再相减即可。
*/

class Solution {
    public int findComplement(int num) {
        long res = 0;
        int count = 0;
        while (num != 0) {
            res = res / 2 + (1 - num % 2) * (long)Math.pow(2, 31);
            num /= 2;
            count ++;
        }
        return (int)(res / Math.pow(2, 32 - count));
    }
}

class Solution {
    public int findComplement(int num) {
        int result = 0;
        while (result < num) {
            result = (result << 1) | 1;
        }
        return result - num;
    }
}