/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive（区分大小写）, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

1.回文数的组合问题，转化为字母的偶数个的个数问题，且可以存储一个奇数。因此转化为数组存储个数，并加入计数器统计个数。

*/

class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[58];
        char[] c = s.toCharArray();
        int count = 0;
        int flag = 0;
        for(char i : c){
            map[i - 65] ++;
            if(map[i - 65] % 2 == 0){
                count ++;
                flag --;
            }else{
                flag ++;
            }
        }
        count *= 2;
        count += flag >= 1 ? 1 : 0;
        return count;
    }
}