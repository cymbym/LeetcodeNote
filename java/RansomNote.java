/*
Given an arbitrary ransom note string and another string containing letters from all the magazines,
 write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true



*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		char[] r = ransomNote.toCharArray();
		char[] m = magazine.toCharArray();
        int count = r.length;
		int[] map = new int[28];
		for(char c : r){
			map[c - 97] ++;
		}
		for(char c : m){
			if(map[c - 97] > 0){
				map[c - 97] --;
				count --;
			}
		}
		return count == 0;
    }
}