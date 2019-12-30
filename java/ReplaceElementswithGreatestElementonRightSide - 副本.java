/*
Given an array nums of integers, return how many of them contain an even number of digits.
 

Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.
Example 2:

Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.
 

Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 10^5


1.题目问的是各数有几位数，该位数是否为偶数。不是问二进制中是否有偶数个1。
*/

class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int n: nums) if (isEven(n)) res ++;
        return res;
    }
    public boolean isEven(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt ++;
            n /= 10;
        }
        return cnt % 2 == 0;
    }
}