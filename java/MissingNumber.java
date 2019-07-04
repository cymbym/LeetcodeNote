/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

1.遇到这种问题常会联想到构造异或。由于【两个相同的数异或为0】，【0与某数异或为某数】。利用这两个结论，将数组与0~n全部取异或，结果即为落单的那个数。

*/

class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for(int i = 0; i < nums.length; i ++){
            sum = sum ^ nums[i] ^ i;
            System.out.println(sum);
        }
        return sum;
    }
}