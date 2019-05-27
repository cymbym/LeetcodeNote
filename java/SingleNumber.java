/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

1.用异或就完事了。异或运算的三个特性————自己与自己异或结果为0；与0异或等于本身；异或满足交换律。 


*/

class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            nums[i+1] = nums[i] ^ nums[i+1];
        }
        return nums[nums.length-1];
    }
}