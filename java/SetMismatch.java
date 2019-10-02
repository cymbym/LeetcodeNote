/*
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.

1.由于该数只出现一次，且所有数为1到n。因此在一个循环里即可实现。
  在一个循环里，用一个数组存储1到n出现的次数，出现两次即为第一个。
  同时累加真实和，与现有和。通过对比得到缺失的数。

*/

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] map = new int[nums.length + 1];
        int[] res = new int[2];
        int sumTrue = 0;
        int sumFalse = 0;
        for(int i = 0; i < nums.length; i ++) {
            map[nums[i]] ++;
            if(map[nums[i]] == 2) res[0] = nums[i];
            sumTrue += i + 1;
            sumFalse += nums[i];
        }
        res[1] = res[0] + sumTrue - sumFalse;
        return res;
    }
}