"""
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
Accepted

1.Sting和int的转换
"""

class Solution:
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        len1 = len(a)
        len2 = len(b)
        c = ""
        flag = 0
        if len1 >= len2:
            for i in range(1,len1+1):
                if i <= len2:
                    t = int(a[len1-i]) + int(b[len2-i]) + flag
                else:
                    t = int(a[len1-i]) + flag
                if t >= 2 :
                    t = t - 2
                    flag = 1
                else:
                    flag = 0
                c = str(t) + c
            if flag == 1:
                c = str(flag) + c
        if len1 < len2:
            for i in range(1,len2+1):
                if i <= len1:
                    t = int(a[len1-i]) + int(b[len2-i]) + flag
                else:
                    t = int(b[len2-i]) + flag
                if t >= 2 :
                    t = t - 2
                    flag = 1
                else:
                    flag = 0
                c = str(t) + c
            if flag == 1:
                c = str(flag) + c
        return c