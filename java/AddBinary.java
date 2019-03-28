/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
Accepted

1.Sting和int的转换
*/

class Solution {
    public String addBinary(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();
        int x = 0;
        int y = 0;
        String s = "";
        if(len_a >= len_b){
            int i = 0;
            int flag = 0;
            while(i < len_a){
                if(i < len_b){
                    x = Integer.parseInt(a.substring(len_a - i - 1, len_a - i)); 
                    y = Integer.parseInt(b.substring(len_b - i - 1, len_b - i)); 
                    s = (x + y + flag) % 2 + s;
                    flag = x + y + flag > 1 ? 1 : 0;
                    i ++ ;
                }else{
                    x = Integer.parseInt(a.substring(len_a - i - 1, len_a - i)); 
                    s = (x + flag) % 2 + s;
                    flag = x + flag > 1 ? 1 : 0;
                    i ++ ;
                }
            }
            s = flag > 0 ? 1 + s : s;
        }else{
            int i = 0;
            int flag = 0;
            while(i < len_b){
                if(i < len_a){
                    x = Integer.parseInt(a.substring(len_a - i - 1, len_a - i)); 
                    y = Integer.parseInt(b.substring(len_b - i - 1, len_b - i)); 
                    s = (x + y + flag) % 2 + s;
                    flag = x + y + flag > 1 ? 1 : 0;
                    i ++ ;
                }else{
                    y = Integer.parseInt(b.substring(len_b - i - 1, len_b - i)); 
                    s = (y + flag) % 2 + s;
                    flag = y + flag > 1 ? 1 : 0;
                    i ++ ;
                }
            }
            s = flag > 0 ? 1 + s : s;
        }
        return s;
    }
}