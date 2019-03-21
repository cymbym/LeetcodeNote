"""
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

1.直接利用判断循环语句求解。
"""


class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        s=""
        if strs == []:
            return s
        else:
            len0 = len(strs)
            if len0 == 1:
                return strs[0]
            else:
                lens = []
                for i in range(len0):
                    lens.append(len(strs[i]))
                len1 = min(lens)
                for j in range(len1):
                    t = 0
                    for i in range(len0-1):
                        if strs[i][j] == strs[i+1][j]:
                            t = t + 1
                        else:
                            return s
                    if t == len0 - 1:
                        s = s + strs[i][j]
            return s