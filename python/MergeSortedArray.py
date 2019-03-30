"""
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

1.由于是用nums1来存储结果，如果对nums1从头开始存储，会将其覆盖掉，因此考虑由大到小存储到nums1的尾部至头部
"""

class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        if m == 0:
            for i in range(0,n):
                nums1[i] = nums2[i]
        r = s = t = 1
        while r <= m and s <= n :
            if nums1[m - r] >= nums2[n - s]:
                nums1[n + m - t] = nums1[m - r]
                r = r + 1
            else:
                nums1[n + m - t] = nums2[n - s]
                s = s + 1
            t = t + 1
        if s < n:
            for i in range(s,n+1):
                nums1[n - i] = nums2[n - i]
        elif s == n:
            nums1[0] = nums2[0]           
        