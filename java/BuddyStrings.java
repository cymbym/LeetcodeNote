/*
Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

 

Example 1:

Input: A = "ab", B = "ba"
Output: true
Example 2:

Input: A = "ab", B = "ab"
Output: false
Example 3:

Input: A = "aa", B = "aa"
Output: true
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
 

Note:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist only of lowercase letters.

*/

class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        else {
            boolean[] map = new boolean[26];
            char[] a = A.toCharArray();
            char[] b = B.toCharArray();
            int cnt = 0;
            char prev = '\0';
            char curr = '\0';
            boolean existSame = false;
            for (int i = 0; i < a.length; i ++) {
                if (a[i] != b[i]) {
                    if (cnt == 0) {
                        cnt ++;
                        prev = a[i];
                        curr = b[i];
                    } 
                    else if (cnt == 1) {
                        cnt ++;
                        if (prev != b[i] || curr != a[i]) return false;
                    }
                    else return false;
                }
                else {
                    if (!existSame) {
                        if (map[a[i] - 97] == true) existSame = true;
                        else map[a[i] - 97] = true;
                    }
                }
            }
            return cnt == 0 ? existSame : cnt == 2 ;
        }
    }
}