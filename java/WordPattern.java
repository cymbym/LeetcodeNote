/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
	
1.首先将str转化为String[]的形式，便于比较。需注意截取每个单词的结尾是【空格】或者str的【末位】，因此得分开讨论（贼麻烦）。
  同时在截取的过程中，和pattern的长度进行比较，不一致则报错。
2.在将pattern和str匹配时，采用HashMap的形式。

*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<Character, String>();
		char[] c = pattern.toCharArray();
		String[] s = divideStr(str, c.length);
        if(s == null) return false;
		for(int i = 0; i < c.length; i ++){
			if(!map.containsKey(c[i])){
				if(!map.containsValue(s[i])){
					map.put(c[i], s[i]);
				}else{
					return false;
				}
			}else{
				if(!map.get(c[i]).equals(s[i])) return false;
			}
		}
		return true;
    }
	private String[] divideStr(String str, int len){
		char[] c = str.toCharArray();
		String[] res = new String[len];
		int count = 0;
		int flag = 0;
		for(int i = 0; i <= c.length; i ++){
            if(count >= len) return null;
			if(i == c.length){
				res[count] = str.substring(flag, i);          
				flag = i + 1;
			}else if(Character.isSpace(c[i])){
				res[count] = str.substring(flag, i);          
				flag = i + 1;
				count ++;
			}
		}
		return (count == len-1) ? res : null;
	}
}

