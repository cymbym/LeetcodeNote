/*
We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
 For example, if A = 'abcde', then it will be 'bcdea' after one shift on A.
 Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
Note:

A and B will have length at most 100.


1.直接用substring()和equals()进行比较。
*/

class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        else if (A.equals(B)) return true;
        else{
            for (int i = 0; i < A.length(); i ++) {
                if (A.substring(i, A.length()).equals(B.substring(0, A.length() - i)) && A.substring(0, i).equals(B.substring(A.length() - i, A.length()))) return true;
            }
            return false;
        }
        
    }
}