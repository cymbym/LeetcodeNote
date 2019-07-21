/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

 



 
Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
 

Note:

You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.

1.先将每一行都存储为数组中，并转存到HashMap，同时存储层数。
  随后将字符串数组的每个字符串都与之匹配。若一直为同一层则存储。

*/

class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        int[] map = new int[28];
        String[] s = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < 3; i ++) {
            char[] c_s = s[i].toCharArray();
            for (char c : c_s) {
                map[c - 'a'] = i;
            }
        }
        for (String word : words) {
            char[] c_s = word.toCharArray();
            boolean flag = true;
            int temp = ( c_s[0] - 'a' < 0) ? map[c_s[0] - 'A'] : map[c_s[0] - 'a'];
            for (char c : c_s) {
                if ( c - 'a' < 0) {
                    if (map[c - 'A'] != temp) {
                        flag = false;
                        break;
                    } 
                }else {
                    if (map[c - 'a'] != temp) {
                        flag = false;
                        break;
                    } 
                }
            }
            if (flag) res.add(word);
        }
        
        String[] ans = new String[res.size()];
        for (int i = 0; i < ans.length; i ++) ans[i] = res.get(i);
        return ans;
    }
}