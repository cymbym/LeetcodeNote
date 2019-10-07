/*
Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].


1.首先只能有一个数大于后一个数，否则直接return false。
2.画图：对于这个突减的数，如4，2，得确保4和2，若4大于其后面两个数、且2小于其前面两个数，则报错，如3，4，2，3。因为此时不管4或2怎么调整，2或4都有问题，即必须同时调整。
*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] > nums[i + 1]) {
                cnt ++;
                if (i + 2 < nums.length && nums[i] > nums[i + 2]) {
                    if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
                        return false;
                    }
                }
            }
            if (cnt > 1) return false;
        }
        return true;
    }
}