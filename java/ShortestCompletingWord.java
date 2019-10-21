/*
Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate.
 Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times.
 For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
Note:
licensePlate will be a string with length in range [1, 7].
licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
words will have a length in the range [10, 1000].
Every words[i] will consist of lowercase letters, and have length in range [1, 15].


1.我的解：在一个数组int[] map中，存储licensePlate中各数出现的次数；用一个整型int cnt，存储出现各字母的总次数。3ms。
  挨个判断各个字符串是否能够消掉map和cnt，若能则该数符合CompletingWord，随后不断更新最小的CompletingWord即可。
  其中，每次判断都调用map.copy()，因为map是引用数据类型，直接用作方法的参数会改变值。  
2.最优解：每次都临时创建map和判断各个字符串。  1ms。
*/

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String res = "";
        char[] licenseC = licensePlate.toCharArray();
        int[] map = new int[26];
        int cnt = 0;
        for (char c: licenseC) {
            if (c >= 'a' && c <= 'z') {
                map[c - 'a'] ++;
                cnt ++;
            }
            else if (c >= 'A' && c <= 'Z') {
                map[c - 'A'] ++;
                cnt ++;
            }
        }
        for (String s: words) {
            if (res.length() == 0 || res.length() > s.length()) {
				if (isCompletingWord(s, map.clone(), cnt)) {
					if(res.length() == 0 || res.length() > s.length()) res = s;
				}
			}
        }
        return res;
    }
    public boolean isCompletingWord(String s, int[] map, int cnt) {
        char[] c = s.toCharArray();
        for (char i: c) {
            if (cnt <= 0) return true;
            else {
                if (i >= 'a' && i <= 'z') {
                    map[i - 'a'] --;
                    if (map[i - 'a'] >= 0) cnt --;
                }
                else if (i >= 'A' && i <= 'Z') {
                    map[i - 'A'] --;
                    if (map[i - 'A'] >= 0) cnt --;
                }
            }
        }
        return cnt == 0;
    }
}


class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] cs = licensePlate.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            char key = '0';
            if (c >= 97 && c <= 122) {
                key = c;
            } else if (c >= 65 && c <= 90) {
                key = (char) (c + 32);
            }
            if (key != '0') {
                sb.append(key);
            }

        }

        String check = sb.toString();
        String result = null;
        int lgth = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() < lgth && judge(check, word)) {
                result = word;
                lgth = word.length();
            }
        }
        return result;
    }

    private boolean judge(String ck, String wd) {
        if (wd.length() < ck.length()) {
            return false;
        }
        int[] ls = new int[26];
        for (char c : wd.toCharArray()) {
            ls[c - 'a']++;
        }
        for (char c : ck.toCharArray()) {
            if (ls[c - 'a'] == 0) {
                return false;
            }
            ls[c - 'a']--;
        }
        return true;
    }
}