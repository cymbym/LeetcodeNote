/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

1.一开始采用hashmap，真慢啊。
2.改用数组存储，速度快了不少。发现提前将s通过s.toCharArray()存储在char[] c_s中，并没有比每次循环重新转化快，而且还会额外消耗空间。


*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }else{
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            char[] c_s = s.toCharArray();
            char[] c_t = t.toCharArray();
            for(int i = 0; i < c_s.length; i ++){
                if(map.containsKey(c_s[i])){
                    int temp = map.get(c_s[i]);
                    if(temp == -1){
                        map.remove(c_s[i]);
                    }else{
                        map.put(c_s[i], temp+1);
                    }
                }else{
                    map.put(c_s[i], 1);
                }
                if(map.containsKey(c_t[i])){
                    int temp = map.get(c_t[i]);
                    if(temp == 1){
                        map.remove(c_t[i]);
                    }else{
                        map.put(c_t[i], temp-1);
                    }
                }else{
                    map.put(c_t[i], -1);
                }
            }
            return map.isEmpty();
        }
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }else{
            int[] map = new int[128];
            char[] c_s = s.toCharArray();
            char[] c_t = t.toCharArray();
            for(char c : c_s){
                map[c]++;
            }
            for(char c : c_t){
                map[c]--;
                if(map[c] < 0)return false;
            }
            return true;
        }
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }else{
            int[] map = new int[128];
            for(char c : s.toCharArray()){
                map[c]++;
            }
            for(char c : t.toCharArray()){
                map[c]--;
                if(map[c] < 0)return false;
            }
            return true;
        }
    }
}

