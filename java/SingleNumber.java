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

1.�����������ˡ����������������ԡ��������Լ����Լ������Ϊ0����0�����ڱ�����������㽻���ɡ� 


*/

class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            nums[i+1] = nums[i] ^ nums[i+1];
        }
        return nums[nums.length-1];
    }
}