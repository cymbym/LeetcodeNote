/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false

1.原本想利用辗转相除法，但一旦出现2^31=2147483647，这种数，找它的最小公因数会引起超时。
2.最优解：双指针+分而治之。不断取区间的一半，直接找该数的根号。


*/



class Solution {
    public boolean isPerfectSquare(int num) {
		long head = 0;
		long tail = num;
		while(tail > head){
            if(tail - head == 1){
                if(head * head == num || tail * tail == num){
                    return true;
                }else
                    return false;
            }
			long mid = head + (tail - head) / 2;
			long temp = mid * mid;
			if(temp == num){
				return true;
			}else if(temp > num){
				tail = mid;
			}else{
				head = mid;
			}
		}
		return head * head == num;
    }
}