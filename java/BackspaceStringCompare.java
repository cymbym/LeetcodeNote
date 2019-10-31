/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?

1.我的解法：利用到了栈。三次循环。

*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack stackS = new Stack();
        Stack stackT = new Stack();
        for (char c: S.toCharArray()) {
            if (c == '#') {
                if (!stackS.empty()) stackS.pop();
            }
            else stackS.push(c);
        }
        for (char c: T.toCharArray()) {
            if (c == '#') {
                if (!stackT.empty()) stackT.pop();
            }
            else stackT.push(c);
        }
        if (stackS.empty()) return stackT.empty();
        else if (stackS.size() != stackT.size()) return false;
        else {
            for (int i = 0; i < stackS.size(); i ++) {
                if (stackS.pop() != stackT.pop()) return false;
            }
            return true;
        }
    }
}