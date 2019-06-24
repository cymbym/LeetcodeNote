/*
Reverse bits of a given 32 bits unsigned integer.

 

Example 1:

Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
 so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: 11111111111111111111111111111101
Output: 10111111111111111111111111111111
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
 so return 3221225471 which its binary representation is 10101111110010110010011101101001.
 

Note:

Note that in some languages such as Java, there is no unsigned integer type.
 In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation.
 Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 

Follow up:

If this function is called many times, how would you optimize it?

1.第一个思路是把int转化为bit，随后用逆序取处理。
2.但需注意的是，计算机本身是将int视为bit的，因此只需要进行移位运算即可。
  即原数先和1进行与运算，判断最后一位是0还是1，判断结果即为最后一位的值；将最后一位的值加至result；继续对原数进行右移，对result进行左移，比较下一个数。

*/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
		for(int i = 0; i < 32; i++){
			result += (n & 1);
            result = (i == 31) ? result : (result << 1);
            n = n >> 1;
		}
		return result;
    } 
}