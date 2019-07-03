/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

1.在一次循环中干两件事：
	判断该数nums[i]是否为0（若为0则找到下一个不为0的数nums[i + zero_num]），并累加0的个数zero_num，作为Flag；
	若zero_num存在：若(i + zero_num) < nums.length，则将某位置的数nums[i]替换为下一个不为零的数nums[i + zero_num]；
	                若(i + zero_num) >= nums.length，则将某位置的数nums[i]替换为0。
	

*/


class Solution {
    public void moveZeroes(int[] nums) {
        int zero_num = 0;
        for(int i = 0; i < nums.length; i ++){
            while((i + zero_num) < nums.length && nums[i + zero_num] == 0) zero_num ++;
            if(zero_num != 0) nums[i] = ((i + zero_num) < nums.length) ? nums[i + zero_num] : 0;
        }
    }
}

