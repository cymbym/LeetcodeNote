/*
Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

 

Example 1:

Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:

Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
Example 3:

Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 

Note:

Note that in some languages such as Java, there is no unsigned integer type.
 In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation.
 Therefore, in Example 3 above the input represents the signed integer -3.
 

Follow up:

If this function is called many times, how would you optimize it?

1.int型与1做与运算，结果为该数二进制形式的最后一位。因此累加最后一位即可。
2.>>>右移是直接右移，不考虑符号位。>>右移是右移后，将符号位按原符号补齐，如为负数，则将不断在左边补1。由于这题不考虑符号位，因此采用>>>才能得到结果。
3.注意n右移的过程，如果类似190的Reverse Bits中，采用了for(int i = 0; i < 32; i++)，能得到结果，但时间不是最优。
	应该像下述答案中：在n右移过程中，一旦为0，则结束计数。


*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0){
            result += n & 1;
            n = n >>> 1;
        }
        return result;
    }
}