"""
Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

1.关于两数之和，要返回某两数的索引，在python中可以考虑利用【数值+索引位置->建立字典】。
2.关于这种遍历寻找两数的问题，可以考虑【一边遍历，一边建立字典】。
"""

class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict={}
        for i in range(0,len(nums)):
            temp = target - nums[i]
            if temp in dict:
                return [i,dict[temp]]
            dict[nums[i]]=i
        
