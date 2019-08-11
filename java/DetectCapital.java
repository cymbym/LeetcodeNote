/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False
 

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

1.若只有一位，则直接输出true。
2.从前两位判断三种情况：大+大+全大，大+小+全小，小+全小。
3.两个函数：判断其余String为全大/小。

*/




class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) return true;
        else {
            int flag = 0;
            if (Character.isUpperCase(word.charAt(0))) {
                if (Character.isUpperCase(word.charAt(1))) return isUpper(word.substring(2, word.length()));
                else return isLower(word.substring(2, word.length()));
            } else return isLower(word.substring(1, word.length()));
        }
    }
    
    public boolean isUpper(String s) {
        for (int i = 0; i < s.length(); i++) if (Character.isLowerCase(s.charAt(i))) return false;
        return true;
    }
    public boolean isLower(String s) {
        for (int i = 0; i < s.length(); i++) if (Character.isUpperCase(s.charAt(i))) return false;
        return true;
    }
}