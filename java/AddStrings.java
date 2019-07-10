/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

1.将问题转化为char[]，从最末尾逐位向高位累加，但结果并不优化。10ms。
2.最优解仍用String进行处理。1ms。

*/

class Solution {
    public String addStrings(String num1, String num2) {
        String res = "";
        char[] c1;
        char[] c2;
        if(num1.length() > num2.length()) {
            c1 = num2.toCharArray();
            c2 = num1.toCharArray();
        }else{
            c1 = num1.toCharArray();
            c2 = num2.toCharArray();			
        }
        int flag = 0;
        for(int i = 1; i <= c1.length ; i ++) {
            int temp = c1[c1.length - i] + c2[c2.length - i] - 96 + flag;
            if(temp < 10) {
                res = temp + res;
                flag = 0;
            }else {
                res = (temp - 10) + res;
                flag = 	1;
            }
        }
        for(int i = c1.length + 1; i <= c2.length ; i ++) {
            int temp = c2[c2.length - i] - 48 + flag;
            if(temp < 10) {
                res = temp + res;
                flag = 0;
            }else {
                res = (temp - 10) + res;
                flag = 	1;
            }
        }
        if(flag ==  1) {
            res = flag + res;
        }
        return res;
    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        // corner case check
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0){
            return null;
        }

		int p1=num1.length() - 1, p2=num2.length() - 1; 
		int len = Math.max(num1.length(), num2.length()) + 1;
        char[] array = new char[len];
        int k = len - 1;
        int carry=0;

        while(p1 >= 0 || p2 >= 0) {
            int num1Val = 0, num2Val = 0;
            
            if(p1 >= 0) {
                num1Val = num1.charAt(p1) - '0';
                p1--;
            }
            
            if(p2 >= 0) {
                num2Val = num2.charAt(p2) - '0';
                p2--;
            }
            int sum = (carry + num1Val + num2Val);
            array[k] = (char)('0' + (sum%10));
            carry = sum/10;
            k--;
        }
        array[k] = (char)(carry+'0');

        // check if the first index is filled
        if (array[0] != '0') {
            return String.valueOf(array);
        }
        // get rid of the first empty index
        return String.valueOf(array).substring(1);
    }
}