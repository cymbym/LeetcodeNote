/*
Given an array A of strings made only from lowercase letters,
 return a list of all characters that show up in all strings within the list (including duplicates).
 For example, if a character occurs 3 times in all strings but not 4 times,
 you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]
 

Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter


1.用一个map存储重复出现的数及对应的次数。用一个tmp挨个存储每个数及对应的次数。
2.挨个将map和tmp进行比较。更新map。
*/

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<String>();
        int[] map = mapString(A[0]);
        for (int i = 1; i < A.length; i ++) {
            int[] tmp = mapString(A[i]);
            for (int j = 0; j < map.length; j ++) {
                map[j] = Math.min(map[j], tmp[j]);
            }
        }
        for (int j = 0; j < map.length; j ++) {
            for (int k = 0; k < map[j]; k ++) {
                res.add(String.valueOf((char)('a' + j)));
            }
        }
        return res;
    }
    public int[] mapString(String s) {
        int[] tmp = new int[26];
        for (char c: s.toCharArray()) {
            tmp[c - 'a'] ++;
        }
        return tmp;
    }
}