# encoding:utf-8
"""
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

1.对String进行处理
"""

class Solution:
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int

        """
        t = 0
        length = len(s)
        if s == "" :
            return 0
        if s[-1] == " ":
            flag = 0
        else:
            flag = 1
        i = 1
        while i <= length:
            if flag == 1:
                if s[length-i] != " ":
                    t = t + 1
                    if i == length:
                        return t
                else:
                    return t
            else:
                if i == length and s[length - i] == " ":
                    return 0
                elif s[length-i] != " ":
                    flag = 1
                    i = i - 1
            i = i + 1

