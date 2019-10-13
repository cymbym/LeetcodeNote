/*
Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.

Note:
s.length will be between 1 and 50,000.
s will only consist of "0" or "1" characters.


1.我的解法：相当于两层循环。但超时了。
2.最优解：在一层循环里，只要统计该位置连续出现的数即可。若连续出现的计数，小于前一类连续出现的计数，则必可生成需要的答案。
*/


class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i ++) {
            int j = i;
            int cnt0 = 0;
            int cnt1 = 0;
            if (c[j + 1] != c[j])  res++;
            else {
                while (j + 1 < c.length && c[j + 1] == c[j]) {
                    cnt0 ++;
                    j ++;
                }
                j ++;
                while (j + 1 < c.length && c[j + 1] == c[j]) {
                    cnt1 ++;
                    j ++;
                    if (cnt0 == cnt1) res ++;
                }
            }
        }
        return res;
    }
}

class Solution {
    public int countBinarySubstrings(String s) {
        char[] a = s.toCharArray();
        int currentcount = 1, prevcount = 0, ans = 0;
        for(int i = 1; i < a.length; i++) {
            if(a[i] == a[i - 1]) {
                currentcount++;
            } else {
                prevcount = currentcount;
                currentcount = 1;
            }
            if(prevcount >= currentcount) {
                ans++;
            }
        }
        return ans;
    }
}