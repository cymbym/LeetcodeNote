/*
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 2^0 = 1
Example 2:

Input: 16
Output: true
Explanation: 2^4 = 16
Example 3:

Input: 218
Output: false

1.采用辗转相除法。
2.答案用了2次幂的与运算，一行就ok，跪了：return (n > 0 && (n & (n - 1)) == 0)。佩服佩服。


*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
			return false;
		}else{
			while(n != 1){
			  if(n % 2 != 0){
				  return false;
			  }else{
				  n /= 2;
			  }
			}
			return true;
		}
    }
}