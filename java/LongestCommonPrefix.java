/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

1.我采用的是直接利用判断循环语句求解。如Leets，Leetcode，Leed，先匹配L，后e，再e。
2.答案是采用两两比较。如Leets，Leetcode，Leed，先由前两者匹配Leet，后由Leet与Leed匹配。
PS：感觉答案的方法更合理
*/


class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0){
            return "";
        }else if(len == 1){
            return strs[0];
        }else{
            int min = strs[0].length(); 
            for(int i = 1; i < len; i ++){
                if(min > strs[i].length()){
                    min = strs[i].length();
                }
            }
            String y=  new String();
            for(int j = 0; j < min; j ++){
                for(int k = 0; k < len-1; k ++){
                     if( (strs[k].substring(j, j + 1)).equals(strs[k+1].substring(j, j + 1)) == false){
                         return y;
                     }
                }
                y= y + strs[0].substring(j, j + 1);
            }
            return y;
        }
    }  
}

