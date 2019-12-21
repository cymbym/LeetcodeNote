/*
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars
 (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.

1.先将chars及其个数存储到数组map中。
2.words中的数及其个数挨个存到数组tmp中，若某个字母的需求超出map，则该数不存储。
                                        若所有字母都能在map下被满足，则该数可以被chars满足。
*/

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        for (char c: chars.toCharArray()) map[c - 'a'] ++;
        int res = 0;
        for (String w: words) {
            int[] tmp = new int[26];
            boolean store = true;
            for (char i: w.toCharArray()) {
                tmp[i - 'a'] ++;
                if (tmp[i - 'a'] > map[i - 'a']) {
                    store = false;
                    break;
                }
            }
            if (store) res += w.length();
        }
        return res;
    }
}