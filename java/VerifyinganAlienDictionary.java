/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet,
 return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.)
 According to lexicographical rules "apple" > "app", because 'l' > '∅',
 where '∅' is defined as the blank character which is less than any other character (More info).
 

Note:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are english lowercase letters.


1.先将order转存到一个数组中，索引为字母，值为顺序。
2.对words中的词两两进行比较：如果前者靠后，直接报错；如果前者靠前，直接输出；如果相等则比较下一位。
3.比较过程中，可能会出现["apple","app"]的情况，则判断比较完的位数是否刚好等于app的长度，若相等，说明app应该靠前不是靠后，报错。
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        char[] map = order.toCharArray();
        int[] dict = new int[26];
        for (int i = 0; i < map.length; i ++) dict[map[i] - 'a'] = i;
        char[] tmp1 = words[0].toCharArray();
        char[] tmp2 = words[0].toCharArray();
        for (int i = 1; i < words.length; i ++) {
            tmp1 = tmp2;
            tmp2 = words[i].toCharArray();
            int len = 0;
            while (len < tmp1.length && len < tmp2.length) {
                if (dict[tmp1[len] - 'a'] > dict[tmp2[len] - 'a']) return false;
                else if (dict[tmp1[len] - 'a'] < dict[tmp2[len] - 'a']) break;
                else len ++;
            }
            if (tmp1.length > tmp2.length && len == tmp2.length) return false;
        }
        return true;
    }
}