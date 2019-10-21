/*
In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Example 1:

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 

Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 

Note:

nums will have a length in the range [1, 50].
Every nums[i] will be an integer in the range [0, 99].
			

1.在循环里找最大和第二大即可。			
*/

class Solution {
    public int dominantIndex(int[] nums) {
        int res = -1;
        int first = 0;
        int second = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > first) {
                res = i;
                second = first;
                first = nums[i];
            }
            else if (nums[i] > second) second = nums[i];
        }
        return first >= 2 * second ? res : -1;
    }
}