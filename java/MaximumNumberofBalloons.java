/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 10^4
text consists of lower case English letters only.


1.将字符串中的字符及其出现的次数存储起来，随后与balloon匹配，统计各字符出现一次或两次的最小值。

*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];
        for (char c: text.toCharArray()) cnt[c - 'a'] ++;
        int res = Integer.MAX_VALUE;
        String balloon = "abn";
        for (char c: balloon.toCharArray()) res = Math.min(res, cnt[c - 'a']);
        balloon = "lo";
        for (char c: balloon.toCharArray()) res = Math.min(res, cnt[c - 'a'] / 2);
        return res;
    }
}