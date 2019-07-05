/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = -2, b = 3
Output: 1

1.看一看二进制半加器的原理，https://blog.csdn.net/weixin_37868901/article/details/82556737
	如，5=101，7=111，12=1100：
	首先用两数异或计算加和，5^7=010；
	随后用两数与计算进位，5&7=1010；
	………（重复上述，直至进位为0）
	得到完整的和。

*/



class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
			int c = a ^ b;		//计算加和（无进位）
			b = (a & b) << 1;	//计算进位：当进位为0时，得到的和才是完整的；否则，还需继续将加和与进位叠加。
			a = c;
		}
		return a;
    }
}
