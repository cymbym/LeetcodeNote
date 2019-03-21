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

1.�Ҳ��õ���ֱ�������ж�ѭ�������⡣��Leets��Leetcode��Leed����ƥ��L����e����e��
2.���ǲ��������Ƚϡ���Leets��Leetcode��Leed������ǰ����ƥ��Leet������Leet��Leedƥ�䡣
PS���о��𰸵ķ���������
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

