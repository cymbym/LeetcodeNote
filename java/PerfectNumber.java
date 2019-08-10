/*
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)

1.一开始的解法是：从num / i, 一直遍历到1，每次都减去num / i。但超时了。
2.后来改用：从num / i, 一直遍历到根号num，每次都减去num / i 和 i。1ms。
3.最优解。0ms:
	6: 2x3 true

	28: 4x7 true

	120: 8x15 false

	496: 16x31 true

	2016: 32x63 false

	8128: 64x127 true
	
  规律：[2的(n-1)次方] *  [2的n次方再减1]
  



*/




class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        else {
            int temp = num;
            for (int i = 2; i * i <= temp; i ++) {
                if (temp % i == 0){
                    if (i * i != temp)  num -= (temp / i + i);
                    else num -= temp / i;
                }
            }
            return num == 1;
        }
    }
}

public boolean checkPerfectNumber3(int num) {
    int[] primes = {2,3,5,7,13};
    for (int p: primes) {
        if ((1 << (p - 1)) * ((1 << p) - 1) == num) {
            return true;
        }
    }
    return false;
}