"""
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

1.注意思路，第一想法是避开从左到右遍历和使用迭代，但仔细想想这样并不合理；
2.其实是可以从左到右遍历的，一旦之前遍历到的结果为负，即抛弃，否则可以一直往后累加。
"""

class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sums = 0
        maximun = nums[0]
        for i in range(0,len(nums)):
            sums = sums + nums[i]
            if sums > maximun:
                maximun = sums
            if sums < 0:
                sums = 0
        return maximun