/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

1.我的：将问题转化为【逆序+不变】交叠处理的形式，全程用char[]读取，用String的+运算更新。11ms。。11ms。
2.最优解：将问题用char[]处理，若处于该区间内，则将字符交换位置。最后char[]转String。0ms。
*/


class Solution {
    public String reverseStr(String s, int k) {
        String res = "";
        int cnt = s.length() / k;
        for (int i = 0; i < cnt; i ++) {
            if (i % 2 == 0) res += revStr(s.substring(i * k, i * k + k));
            else res += s.substring(i * k, i * k + k);
        }
        if (cnt % 2 == 0) res += revStr(s.substring(cnt * k, s.length()));
        else res += s.substring(cnt * k, s.length());
        return res;
    }
    private String revStr(String s) {
        String res = "";
        char[] c = s.toCharArray();
        for (int i = 1; i <= c.length; i ++) res += c[c.length - i];
        return res;
    }
}

class Solution {
    public String reverseStr(String s, int k) {
  char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i += 2 * k) {
            int j = Math.min(i + k - 1, a.length - 1);
            reverse(a, i, j);
        }
        return String.valueOf(a);
    }
    
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }
}
