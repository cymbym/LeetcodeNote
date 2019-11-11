/*
Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]
 

Example 1:

Input: "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: "III"
Output: [0,1,2,3]
Example 3:

Input: "DDI"
Output: [3,2,0,1]
 

Note:

1 <= S.length <= 10000
S only contains characters "I" or "D".

1.最优解：如果一开始是I，就在最开始置最小数；如果一开始是D，就在最开始置最大数。以此构造递归。
*/

class Solution {
    int[] res;
    int head;
    int tail;
    public int[] diStringMatch(String S) {
        char[] C = S.toCharArray();
        head = 0;
        tail = C.length;
        res = new int[C.length + 1];
        for(int i = 0; i < C.length; i ++) {
            match(C[i], i);
        }
        res[C.length] = head;
        return res;
    }
    public void match(char c, int i) {
        if (c == 'I') res[i] = head ++;
        else res[i] = tail --;
    }
}