/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.


1.对于寻找重复字符问题，常用到Hash表的方法，或者数组的方法。
2.Ans1中用到了HashMap，9ms。
3.Ans2中用了数组map_s[c_s] = c_t; map_t[c_t] = c_s; 在数组的key和value中分别存储两个字符串该重复字符对应的字符。3ms。
4.Ans3中用了数组map_s[c_s] = c_t; map_t[c_t] = c_s; 在数组的key和value中分别存储两个字符串该重复字符对应的字符。1ms。
5.Ans2和Ans3所不同的是，
  前者用了都是String的方法，如String.charAt(i)和String.length()。String是类，因此耗时多。
  后者用了String.toCharArray()生成char[]，随后用的都是char[]的方法，如char[i]和char.length。char[]是基本数据类型，因此耗时少。

*/

//Ans1(HashMap):
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }else if(s == ""){
            return true;
        }else{
            HashMap<Character, Integer> map_s = new HashMap();
            HashMap<Character, Integer> map_t = new HashMap();
            for(int i = 0; i < s.length(); i ++){
                char c = s.charAt(i);
                if(!map_s.containsKey(c)){
                    map_s.put(c, i);
                    c = t.charAt(i);
                    if(!map_t.containsKey(c)){
                        map_t.put(c, i);
                    }else{
                        return false;
                    }					
                }else{
                    int j = map_s.get(c);
                    if(t.charAt(i) != t.charAt(j))return false;
                }
            }
            return true;
        }	
    }
}

//Ans2(String):
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }else if(s == ""){
            return true;
        }else{
            char[] map_s = new char[128];
            char[] map_t = new char[128];
            for(int i = 0; i < s.length(); i ++){
                char c_s = s.charAt(i);
                char c_t = t.charAt(i);
                if(map_s[c_s] == 0 && map_t[c_t] == 0){
                    map_s[c_s] = c_t;
                    map_t[c_t] = c_s;		
                }else if(map_s[c_s] != c_t && map_t[c_t] != c_s){
                    return false;
                }
            }
            return true;
        }
    }
}

//Ans3(char[]):
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }else if(s == ""){
            return true;
        }else{
            char[] map_s = new char[128];
            char[] map_t = new char[128];
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            for(int i = 0; i < ss.length; i ++){			
                char c_s = ss[i];
                char c_t = tt[i];
                if(map_s[c_s] == 0 && map_t[c_t] == 0){
                    map_s[c_s] = c_t;
                    map_t[c_t] = c_s;		
                }else if(map_s[c_s] != c_t && map_t[c_t] != c_s){
                    return false;
                }
            }
            return true;
        }
    }
}