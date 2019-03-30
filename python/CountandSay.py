"""
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

1.采用的方法是循环，当时太嫩了，只会用这种粗暴的方法，后来用java写时第一反应是用递归（调用自身函数）算。

"""

class Solution:
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        nums = [1]
        if n == 1:
            return str(nums[0])
        else:
            for i in range(1, n):
                stack = []
                t = 1
                length = len(nums)
                if length == 1:
                    stack.append(1)
                    stack.append(nums[0])
                else:
                    for j in range(1,length):
                        if nums[j-1] == nums[j]:
                            t = t + 1
                        else:
                            stack.append(t)
                            t = 1
                            stack.append(nums[j-1])
                    stack.append(t)
                    stack.append(nums[j])
                nums = stack
            return "".join('%s' %id for id in nums)
