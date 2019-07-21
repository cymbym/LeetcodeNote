/*
You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.

Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.

Given a non-empty string S and a number K, format the string according to the rules described above.

Example 1:
Input: S = "5F3Z-2e-9-w", K = 4

Output: "5F3Z-2E9W"

Explanation: The string S has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:
Input: S = "2-5g-3-J", K = 2

Output: "2-5G-3J"

Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
Note:
The length of string S will not exceed 12,000, and K is a positive integer.
String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
String S is non-empty.

1.转化为char[]，四位一组倒序处理。用String拼接时，时间复杂度极大。600ms。
2.转化为char[]，四位一组倒序处理。用StringBuffer / StringBuilder拼接时，时间复杂度减小了。120ms。
3.最优解：先算出所有字母个数，取余处理得到第一个部分长度，取余部分四位一组正序处理。用StringBuilder拼接。4ms。

*/

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] c = S.toCharArray();
        String res = "";
        boolean flag = false;
        int cnt = 0;
        for (int i = c.length - 1; i >= 0; i --) {
            if (c[i] != '-') {
                    if (cnt == K) {
                        cnt = 0;
                        res = '-' + res;
                    }
                    if (c[i] >= 'a' && c[i] <= 'z') c[i] -= 32;
                    res = c[i] + res;
                    cnt ++;
                }
        }
        return res;
    }
}

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] c = S.toCharArray();
        StringBuffer res = new StringBuffer();
        boolean flag = false;
        int cnt = 0;
        for (int i = c.length - 1; i >= 0; i --) {
            if (c[i] != '-') {
                    if (cnt == K) {
                        cnt = 0;
                        res.insert(0, '-');
                    }
                    if (c[i] >= 'a' && c[i] <= 'z') c[i] -= 32;
                    res.insert(0, c[i]);
                    cnt ++;
                }
        }
        return res.toString();
    }
}

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] c = S.toCharArray();
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        int cnt = 0;
        for (int i = c.length - 1; i >= 0; i --) {
            if (c[i] != '-') {
                    if (cnt == K) {
                        cnt = 0;
                        res.insert(0, '-');
                    }
                    if (c[i] >= 'a' && c[i] <= 'z') c[i] -= 32;
                    res.insert(0, c[i]);
                    cnt ++;
                }
        }
        return res.toString();
    }
}

class Solution {
    public String licenseKeyFormatting(String s, int k) {

        int len = s.length();
        char[] ch = s.toCharArray();
        for (char c : ch)
            if (c == '-') len--;
        if (len == 0) return "";

        int head = len % k;
        if (head == 0) head = k;

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if (c == '-') continue;
            if (head == 0 && cnt % k == 0)
                sb.append('-');

            if (c <= 'Z')
                sb.append(c);
            else
                sb.append((char) (c - 32));

            if (head > 0) head--;
            else cnt++;
        }
        if (sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}