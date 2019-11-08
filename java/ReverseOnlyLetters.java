/*
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

 

Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122 
S doesn't contain \ or "

1.双指针往中间靠，头指针遇到字母则自加1，尾指针遇到字母则自减1，否则双方进行置换。
*/

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] A = S.toCharArray();
        int head = 0;
        int tail = A.length - 1;
        while (head < tail) {
            if (!((A[head] >= 'a' && A[head] <= 'z') || (A[head] >= 'A' && A[head] <= 'Z'))) head ++;
            else if (!((A[tail] >= 'a' && A[tail] <= 'z') || (A[tail] >= 'A' && A[tail] <= 'Z'))) tail --;
            else {
                char tmp = A[head];
                A[head] = A[tail];
                A[tail] = tmp;
                head ++;
                tail --;
            }
        }
        return String.valueOf(A);
    }
}