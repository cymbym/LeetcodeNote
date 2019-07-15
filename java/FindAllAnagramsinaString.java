/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

1.我的思路：双指针分别代表首尾，用数组存储p中各字母出现的次数。一点点地讨论，特繁琐。
2.最优解：同样双指针代表首尾，但思路清晰。
    若尾指针的数存在，则尾指针移动，且map中该数对应的cnt减1，相当于开始统计一个anagram，map开始更新。 =》 相当于当遇到p中的数，start固定，end超越start后，开始统计anagram，并剔除map的过程。
    若尾指针的数不存在，则头指针移动，且该数的cnt加1，若为之前更新后减掉的数，则相当于使之前统计的anagram逐位失效，即还原了map。 =》 相当于遇到非p中的数，end固定，start在追赶end，并还原map的过程。
                                                      若为p中不存在的新数，则头指针会先于尾指针移动到下一个p中存在的数，这期间新数的cnt会随着尾指针移动消失。 =》 相当于start走得快时，end会帮其拆东墙补西墙，只要end在追赶start，start遇到非p的数随便加都有end帮其收拾；只有遇到p中的数，start固定，end超越start后，才会开始统计anagram。
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] c_p = p.toCharArray();
        char[] c_s = s.toCharArray();
        int[] map = new int[28];
        List<Integer> res = new ArrayList<Integer>();
        for (char i : c_p) map[i - 'a'] ++;
        int start = 0;
        int end = 0;
        boolean isP = false;
        int[] temp = map.clone();
        while (end < c_s.length) {
            if (temp[c_s[end] - 'a'] > 0) {
                temp[c_s[end] - 'a'] --;
                if (!isP) start = end;
                isP = true;
                if (end - start == c_p.length - 1) {
                    isP = false;
                    res.add(start);
                    while (end + 1 < c_s.length && c_s[end + 1] == c_s[start]){
                        end ++;
                        start ++; 
                        res.add(start);
                    }
                    if(end + 1 == c_s.length) return res;
                    else{
                        end ++;
                        start ++;
                        while (end > start && map[c_s[end] - 'a'] > 0) end --;
                        start = end;
                    }                  
                }
                else end ++;
            }else{
                isP = false;
                temp = map.clone();
                while (end > start && temp[c_s[end] - 'a'] > 0) end --;
                end ++;
                start = end;
            }
        }
        return res;
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         if (s.length() < p.length()) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int size = p.length();
        int[] map = new int[26];
        for(int i = 0; i < size; i ++) {
            map[p.charAt(i) - 'a'] ++;
        }
        char[] c_s = s.toCharArray();
        int start = 0, end = 0;
        while (end < c_s.length) {
            if (map[c_s[end] - 'a'] > 0) {
                map[c_s[end] - 'a'] --;
                end ++;
            }else {
                map[c_s[start] - 'a'] ++;
                start ++;
            }
            if (end - start == size) res.add(start);
        }
        return res;
    }
}