/*
Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

 

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.
 

Note:

name.length <= 1000
typed.length <= 1000
The characters of name and typed are lowercase letters.

1.在两个字符数组中挨个遍历每个相同的字符，如alex和aaleex：先分别a和aa，l和l，e和ee
2.最后跳出循环，判断A剩下的是否比B的少或者相等，随后判断x和x。
*/

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char[] A = name.toCharArray();
        char[] B = typed.toCharArray();
        int currA = 0, currB = 0, cntA = 1, cntB = 1;
        while (currA < A.length - 1 && currB < B.length - 1) {
            while (currA < A.length - 1 && A[currA] == A[currA + 1]) {
                currA ++;
                cntA ++;
            }
            while (currB < B.length - 1 && B[currB] == B[currB + 1]) {
                currB ++;
                cntB ++;
            }
            if (A[currA] == B[currB] && cntA <= cntB) {
                currA ++;
                currB ++;
                cntA = 1;
                cntB = 1;
            } else return false;
        }
        if (A.length - currA > B.length - currB) return false;
        else {
            while (currB < B.length) {
                if (B[currB] != A[currA]) return false;
                else currB ++;
            }
            return true;
        }
    }
}