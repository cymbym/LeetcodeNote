/*
Given a string S of lowercase letters,
 a duplicate removal consists of choosing two adjacent and equal letters,
 and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made. 
 It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
 and this is the only possible move.
 The result of this move is that the string is "aaca", of which only "aa" is possible,
 so the final string is "ca".
 

Note:

1 <= S.length <= 20000
S consists only of English lowercase letters.


1.我的解法：用一个数组存储要保留的数，若要保留存储为1。
            使用双指针挨个遍历前后要保留的数，若前后要保留的数相等，则不保留。
            直至所有数不再能进行抛弃。
            返回结果（此处用计数器记录剩余的个数，最后方便用char[]转sting）。5ms。
2.最优解：退而求其新的思路。双指针，一个遍历原字符串，一个遍历要存储的字符串。
          若原字符串出现了前后相等，则要存储的字符串退位，原字符串进位，相当于跳过相等的部分。
      
*/

class Solution {
    public String removeDuplicates(String S) {
        char[] C = S.toCharArray();
        int[] I = new int[C.length];
        for (int i = 0; i < I.length; i ++) I[i] ++;
        boolean hasDup = true;
        int cnt = 0;
        while (hasDup) {
            hasDup = false;
            int pre = 0;
            int cur = 1;
            while (cur < I.length) {
                if (I[pre] == 1) {
                    while (cur + 1 < I.length && I[cur] == 0) cur ++;
                    if (I[cur] == 1 && C[pre] == C[cur]) {
                        I[pre] = 0;
                        I[cur] = 0;
                        hasDup = true;
                        cur ++;
                        cnt += 2;
                    }
                }
                pre = cur;
                cur ++;
            }
        }
        char[] res = new char[C.length - cnt];
        cnt = 0;
        for (int i = 0; i < I.length; i ++) {
            if (I[i] > 0) res[cnt ++] = C[i]; 
        }
        return String.valueOf(res);
    }
}

class Solution {
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        int left = 0;
        char[] array = S.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (left != 0 && array[left - 1] == array[i]) {
                left--;
            } else {
                array[left++] = array[i];
            }
        }
        return new String(array, 0, left);
    }
}