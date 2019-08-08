/*
Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

1.我的解法：使用双指针遍历两个String，并使用递归。17ms。
2.最优解：使用indexOf(c, index+1)，从index+1位置开始往后找c，若没找到直接返回-1，若找到继续找下一个c。0ms。

*/




class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        else if (t.length() == 0) return false;
        else{
            int i = 0;
            int j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) return isSubsequence(s.substring(i + 1, s.length()), t.substring(j + 1, t.length()));
                else j ++;
            }
            return false;
            
        }        
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }
}