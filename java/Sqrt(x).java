/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
			 
1.我选择了采用二分法进行处理，取一个窗口，不断改变窗口的区间，
	即将该数与这个区间的中点的平方比较，继续下一轮缩小区间，
	直至该区间的长度小于等于1。此时将区间的上下界与该数比较即可。
	
2.int整型是有界的，当出现溢出时，可采用long或double来处理。

3.最佳方法。其实也类似窗口法，此时的窗口下界为x/i，上界为i。比二分法时间复杂度低哇。如下：
class Solution {
    public int mySqrt(int x) {  
        if (x == 0) return 0;
		long i = x;
		while(i>x/i)
        i=(i+x/i)/2;
		return (int) i;    
    }
}
	
*/

class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }else{
            int minimum = 0;
            int maximum = x / 2;
            while(maximum - minimum != 1){
                int y = (minimum + maximum) / 2;
                System.out.println(y);
                if((long)y * y >= x){
                    maximum = y;
                }else{
                    minimum = y;
                }
            }
            if((long)maximum * maximum <= x){
                return maximum;
            }else{
                return minimum;
            }
        }
    }
}

