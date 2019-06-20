/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701

1.类比168的Excel Sheet Column Title，该题相当于10进制转26进制。本题则是26进制转10进制，利用到了幂次。

*/

class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
		int sum = 0;
		for(int i = 0; i < len; i ++){
			sum += Math.pow(26, i)*convert(s.charAt(len-i-1));
		}
		return sum;
    }
	public int convert(char c){
		return Integer.valueOf(c) - 64;
	}
}