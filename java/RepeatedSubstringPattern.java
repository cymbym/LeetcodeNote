/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)



*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        boolean res = true;
        for (int subStrLen = 1; subStrLen <= len / 2; subStrLen ++) {
            if (len % subStrLen == 0) {
                int step = subStrLen;
                while (step < len) {
                    if (!isRepeated(s, step, subStrLen)) {
                        res = false;
                        break;
                    }
                    else {
                        step += subStrLen;
                        res = true;
                    }
                }
                if (res) return res;
            }
        }
        return false;
    }
    private boolean isRepeated(String s, int step, int subStrLen) {
        if (!s.substring(0,  subStrLen).equals(s.substring(step, step + subStrLen))) return false;
        return true;
    }
}

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        boolean res = true;
        for (int subStrLen = len / 2; subStrLen >= 1; subStrLen --) {
            if (len % subStrLen == 0) {
                int step = subStrLen;
                while (step < len) {
                    if (!isRepeated(s, step, subStrLen)) {
                        res = false;
                        break;
                    }
                    else {
                        step += subStrLen;
                        res = true;
                    }
                }
                if (res) return res;
            }
        }
        return false;
    }
    private boolean isRepeated(String s, int step, int subStrLen) {
        if (!s.substring(0,  subStrLen).equals(s.substring(step, step + subStrLen))) return false;
        return true;
    }
}

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len <= 1) {
            return false;
        }
        char last = s.charAt(len - 1);
        int val = s.lastIndexOf(last, len / 2 - 1) + 1;
        while (val > 0) {
            if (len % val == 0) {
                String pat = s.substring(0, val);
                boolean res = true;
                for (int i = val; i < len; i += val) {
                    if (!s.substring(i, i + val).equals(pat)) {
                        res = false;
                        break;
                    }
                }
                if (res) {
                    return res;
                }
            }
            val = s.lastIndexOf(last, val - 2) + 1;
        }
        return false;
    }
}