/*
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

1.首先原序列为：【1 ~ 9】，【10 ~ 99】，【100 ~ 999】，…… ，即【9^0+1 ~ 9^0+9】，【9^1+1 ~ 9^1+90】，【9^1+9^10+1 ~ 9^1+9^10+900】，……
2.对应长度序列为：【9^0+1*1 ~ 9^0+9*1】9个，【9^1*1+1*2 ~ 9^1*1+90*2】180个，【9^1*1+9^10*2+1*3 ~ 9^1*1+9^10*2+900*3】2700个，……
3.因此，想要将长度序列n映射为对应的原序列num，就必须一层层去匹配，依次减去【9 * 10^0 * 1】，【9 * 10^1 * 2】，【9 * 10^2 * 3】……直至匹配到正确的区间。
	如103，减9后为94<180，故在第二个区间。
4.累加原序列中每层的个数，直至加到正确区间中对应的数。
    9+94/2=56。该数为56。
5.找到该数后，确定长度序列的数对应这个数的第几位flag。
	94%2=2，故为第二位。
6.对该数取余，直至获取所需的位数。
	得到56的第二位为6。
	
PS:注意叒溢出了，于是改用long。
	
*/

class Solution {
    public int findNthDigit(int n) {
        if(n < 10)return n;
        else{
            long i = 1;
            long num = 0;
			long l = (int)n;
            long temp = 9 * (int)Math.pow(10, i - 1) * i;  //步骤2，长度序列中每层的个数
            while(l > temp){
                l -= temp;				//步骤3，减去长度序列中每层的个数直至匹配到正确区间
                num += (temp / i ++);   //步骤4，累加原序列中每层的个数
                temp = 9 * (int)Math.pow(10, i - 1) * i;
            }
            num += ((l - 1) / i + 1);   //步骤4，累加原序列中每层的个数，直至匹配到正确的数
			
            long flag = (l % i == 0) ? i : l % i;  //步骤5，确定所求在该数哪一位
            long res = 0;
            for(long j = 0; j <= i - flag; j ++){
                res = num % 10;			 //步骤6，对该数取余，直至获取所需的位数
                num /= 10;
            }
            return (int)res;
        }
    }
}

