/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

1.第一步，先列出可能情况，找出规律。
    1：1 2
	2：3 4 5
	3：6 7 8 9
	……
	x*(x+1)/2 <= n < (x+1)*(x+2)/2 
	
2.第二步，采用分而治之，不断取中点x，判断中点是否满足上式。若满足，返回x；否则继续改变区间。

*/

class Solution {
    public int arrangeCoins(int n) {
        long head = 0;
		long tail = n;
        while (tail - head > 1) {
			long midFir = head + (tail - head) / 2;
			long midSec = midFir + 1;
			long midThi = midSec + 1;
            if (midFir * midSec / 2 <= n) {
				if (midSec * midThi / 2 > n) return (int)midFir;
				else {
					head = midFir;
				}
			}else tail = midFir;
			if(tail - head == 1) return (int)midFir;
        }
        return (int)tail;
    }
}