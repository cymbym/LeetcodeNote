/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"

1.仔细分析题目，其实就是一个十进制转26进制的问题，用辗转相除法，不断提取余数，直至商变为0结束。
2.需注意如26，52，分别对应Z，AZ，这种余数为0时，需要讨论一下这种情况，将余数变为26，下一个商自减1。即26 = 26*1+0 = 26*0+26 = Z，52 = 26*2+0 = 26*1+26 = AZ
3.看到一个递归解法，一行解决，丧心病狂啊： return n == 0 ? "" : convertToTitle(n / 26) + (char)(--n % 26 + 'A');

*/

class Solution {
    public String convertToTitle(int n) {
        String res = "";
		while(n != 0){
			int remainder = n % 26;
			if(remainder == 0){
				res = convertToLetter(remainder + 26) + res;
				n = n / 26 - 1;
			}else{
				res = convertToLetter(remainder) + res;
				n /= 26;
			}
		}
		return res;
    }
	public char convertToLetter(int n){
		return (char)(n + 64);
	}
}