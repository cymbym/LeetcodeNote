/*
Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings.
 The longest uncommon subsequence is defined as the longest subsequence of one of these strings
 and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence
 by deleting some characters without changing the order of the remaining elements.
 Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be two strings, and the output needs to be the length of the longest uncommon subsequence.
 If the longest uncommon subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc"
Output: 3
Explanation: The longest uncommon subsequence is "aba" (or "cdc"), 
because "aba" is a subsequence of "aba", 
but not a subsequence of any other strings in the group of two strings. 
Note:

Both strings' lengths will not exceed 100.
Only letters from a ~ z will appear in input strings.

1.题意：两个字符串中最长的字符串是否为另一字符串的子字符串，如果是，则返回-1，否则返回最长字符串长度。
2.解法：比较两个字符串的长度，若不相等，则返回长度的较大值；
                              若相等，则再判断两个字符串是否相同，若相同则返回-1，否则返回长度。

*/



class Solution {
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) return Math.max(a.length(), b.length());
        else if (a.equals(b)) return -1;
        else return a.length();
    }
}