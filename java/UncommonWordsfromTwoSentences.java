/*
We are given two sentences A and B.
  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences,
 and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order.

 

Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]
 

Note:

0 <= A.length <= 200
0 <= B.length <= 200
A and B both contain only spaces and lowercase letters.

1.用map存储出现的单词和次数，用set存储只出现一次的单词。最后将set中的单词存储到String[]。

*/

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        HashMap<String, Integer> mapA = new HashMap<String, Integer>();
        HashMap<String, Integer> mapB = new HashMap<String, Integer>();
        HashSet<String> set = new HashSet<String>();
        for (String s: a) {
            int tmp = mapA.getOrDefault(s,0);
            mapA.put(s, tmp + 1);
        }
        for (String s: b) {
            int tmp = mapB.getOrDefault(s,0);
            mapB.put(s, tmp + 1);
        }
        for (String s: a) {
            if (!mapB.containsKey(s)) {
                if (mapA.get(s) == 1) set.add(s);
                else set.remove(s);
            }
        }
        for (String s: b) {
            if (!mapA.containsKey(s)) {
                if (mapB.get(s) == 1) set.add(s);
                else set.remove(s);
            }
        }
        String[] res = new String[set.size()];
        int i = 0;
        for (String s: set) {
            res[i] = s;
            i ++;
        }
        return res;
    }
}

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashSet<String> set = new HashSet<String>();
        for (String s: a) {
            int tmp = map.getOrDefault(s,0);
            map.put(s, tmp + 1);
        }
        for (String s: b) {
            int tmp = map.getOrDefault(s,0);
            map.put(s, tmp + 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) == 1) set.add(key);
        }
        String[] res = new String[set.size()];
        int i = 0;
        for (String s: set) {
            res[i] = s;
            i ++;
        }
        return res;
    }
}