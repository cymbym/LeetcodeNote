/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

1.对String进行处理
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        if(s.equals("") || s.equals(" ")){
            return 0;
        }else if(len == 1){
            return 1;
        }else{
            int i = 0;
            int t = 0;
            int flag = 0;
            while(i < len ){
                if(s.substring(len - i - 1, len - i).equals(" ")){
                    if(flag == 0){
                        i ++ ;
                    }else if(flag == 1){
                        return t;
                    }
                }else{
                    i ++ ;
                    t ++ ;
                    flag = 1;
                }
            }return flag > 0 ? t : 0;
        }
    }
}

