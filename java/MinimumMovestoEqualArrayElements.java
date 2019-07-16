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
假设数组元素最终为X，数组最小元素min需要经过X-min次增长，最大元素max需要经过X-max次增长，(X-min)-(X-max)=max-min就是max不变  其余元素包括min 增长的次数，
经过这些次增长后，min元素和max元素大小相等，且它俩成为当前数组最小元素。   
然后我们再让这俩最小元素增长到当前数组最大元素（初始数组次最大元素max2）的大小，增长的次数是max2-min，最终使得这三个元素相等。
每一次增长都让数组中大小相同的元素增加一个，从1到2到3~~~n，故总共增加了max-min,max2(初始数组次最大元素)-min,max3-min，，，总和就是sum-min*n


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