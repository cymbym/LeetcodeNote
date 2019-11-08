/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000

1.双指针往中间靠，头指针遇到偶数则自加1，尾指针遇到奇数则自减1，否则双方进行置换。
*/

class Solution {
	public int[] sortArrayByParity(int[] A) {
		int head = 0;
		int tail = A.length - 1;
		while (head < tail) {
            if (A[head] % 2 == 0) head ++;
			else if (A[tail] % 2 == 1) tail --;
			else {
				int tmp = A[head];
				A[head] = A[tail];
				A[tail] = tmp;
				head ++;
				tail --;
			}
		}
		return A;
	}
}