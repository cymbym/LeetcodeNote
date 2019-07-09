/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.



*/

class Solution {
    public String addStrings(String num1, String num2) {
		String res = "";
		String s  = "";
		if(num1.length() > num2.length()) {
			s = num1;
			num1 = num2;
			num2 = s;
		}
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int flag = 0;
        for(int i = 1; i <= c1.length ; i ++) {
            int temp = c1[c1.length - i] + c2[c2.length - i] - 96;
            if(temp + flag < 10) {
                res = (temp + flag) + res;
                flag = 0;
            }else {
                res = (temp + flag - 10) + res;
                flag = 	1;
            }
        }
        for(int i = c1.length + 1; i <= c2.length ; i ++) {
            int temp = c2[c2.length - i] - 48;
            if(temp + flag < 10) {
                res = (temp + flag) + res;
                flag = 0;
            }else {
                res = (temp + flag - 10) + res;
                flag = 	1;
            }
        }
        if(flag ==  1) {
            res = flag + res;
        }
        return res;
    }
}