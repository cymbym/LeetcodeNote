"""

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers 
within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 
when the reversed integer overflows.

1.数字反转问题，在python中int和string型的转换较为简洁，且string的逆序输出较为便捷。
	因此考虑转化为string后，逆序处理。
"""

class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        s=str(x)
        if x < 0 :
            y=s[1::]
            s=y+"-"
        s2=s[::-1]
        x2=int(s2)
        if x2 > 2**31-1 or x2 <-2**31:
            return 0
        else:
            return x2