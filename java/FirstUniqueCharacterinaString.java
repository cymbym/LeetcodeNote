/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

1.将出现过的字符存储起来，对s进行至多两次遍历。
2.最优解用到了String的lastIndexOf()与indexOf()，只需对26个字母进行一次遍历即可。

*/

class Solution {
    public int firstUniqChar(String s) {
        char[] c = s.toCharArray();
		int[] temp = new int[28];
		for(char i : c){
			temp[i - 97] ++;
		}
		for(int i = 0; i < c.length; i ++){
			if(temp[c[i] - 97] == 1)return i;
		}
		return -1;
    }
}