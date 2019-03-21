/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers 
within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 
when the reversed integer overflows.

1.数字反转问题，在java中int和string型的转换没有python简洁。
2.因此考虑进行除10取整取余，在int层次进行处理。
*/

class Solution {
    public int reverse(int x) {
        int y;
        if(x < 10 && x > -10){
            return x;
        }else{
            y = 0;
        }
        while(x != 0 && (y < (Math.pow(2,31)-1)/10 && y > -Math.pow(2,31)/10)){
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if( x != 0 ){
            return 0;
        }
        else{
            return y;
        }
    }
}