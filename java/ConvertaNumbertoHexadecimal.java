/*
Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"

1.若为负数，先转化为其补码形式：negToBit(long num)。如-2。2的原码为00……0010，共32位，故-2的补码为11……1110，转化方式为：其相反数的原码的右起第一个1为界，左边取反，右边及该数皆保留。
  由于需要用到10进制转2进制，用辗转相除法，并在循环中同时逐位转化为补码。由于是从最小位开始存储的，故一开始每一位都乘2^31，后续则不断除以2。由于2^31会溢出，故采用long。
2.得到所有数后开始转化为16进制sysConvert(long num)。
*/

class Solution {
    public String toHex(int num) {
        long n = (num >= 0) ? num : negToBit(num);
		return sysConvert(n);
    }
	private long negToBit(long num){
        long res = 0;
        boolean flag = false;
        num = -num;
        for(int i = 0; i < 32; i ++){
            long temp;
            if(!flag){
               	if(num % 2 == 1) flag = true;  //补码取反界限
               	temp = num % 2;				   //补码无需取反
            }else{
              	temp = 1 - num % 2;			   //补码需取反
            }
            num /= 2;
            res = res / 2 + temp * (long)Math.pow(2, 31);    //逐位转为2进制，因为是从最小位开始存储的，故一开始每一位都乘2^31，后续则不断除以2
        }
        return res;
    }
    private String sysConvert(long num){
        String res = "";
        if(num == 0){
            return "0";
        }else{
            while(num != 0){
                long temp = num % 16;
                if(temp >= 10){
                    res = (char)('a' + temp - 10) + res;
                }else{
                    res = temp + res;
                }
                num /= 16;
            }
        }
        return res;
    }
}
