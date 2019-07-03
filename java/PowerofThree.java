/*
Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?

1. Integer上界：由于整型数都存在上界Integer.MAX_VALUE，因此【3的幂次也存在上界】，该上界为3^log3(MaxInt) = 3^[19.56] = 3^19 = 1162261467。【这个上界必被任何3的幂次整除】。
2. 转对数：n=3^i，i=log3(n)，i=logb(3)/logb(n)，java中可以【用%1来获得i的小数部分】，判断是否为0，为0即i为整数。
​	

*/

public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}


public class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (Math.log10(n) / Math.log10(4)) % 1 == 0;
    }
}