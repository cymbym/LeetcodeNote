/*
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums.
 If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].

1.我的解法：从左到右遍历。2ms。
2.最优解：分而治之，不断取区间及中点。0ms。
*/

class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] == target) return i;
            else if (nums[i] > target) return -1;
            else if (nums[i] < target && nums[i + 1] > target) return -1;
        }
        return nums[nums.length - 1] == target ? nums.length - 1 : -1;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // target not found
        return -1;
    }
}