/*
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

1.列举几个例子，找出规律。

每个数都会经历递增的过程，最后达到一个ceiling。
这期间小的元素需要不断向大的元素补齐。因此最小的元素一定是永远在增加的。统计其增加次数即为所求move次数。
【补齐法】：数组最小元素min需要比最大元素max多增加max-min次（max不动的次数），方能补齐二者差距；
            而最小元素min需要比第二大元素max2多增加max2-min次（max2不动的次数），方能补齐二者差距；
			……
            每一次增长都让数组中最小的元素向比其大的元素补齐，从2,3,……,n，故总共增加了max-min,max2-min,max3-min,……,max(n-1)-min次。
            总和就是sum-min*n。


*/

class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = (i <= min) ? i : min;
            sum += i;
        }
        return sum - min * nums.length;
    }
}