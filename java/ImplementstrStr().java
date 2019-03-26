/*
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

1.在string里用循环进行遍历
*/
class Solution {
    public int strStr(String haystack, String needle) {
        int len_all = haystack.length();
        int len = needle.length();
        for(int i = 0; i <= len_all -len; i ++){
            if( haystack.substring(i, i+len).equals(needle) == true)            {
                return i;
            }
        }
        return -1;
    }
}