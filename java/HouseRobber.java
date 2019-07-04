/*
You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
			 
1.偷第i家店   <=>  【第i-2家店的收益(max_first) + 第i家店(nums[i])】大
2.不偷第i家店 <=>  【第i-1家店的收益(max_second) 				  】大
3.因此需要考虑前面两家店带来的收益。
4.类似冒泡排序的更新时，需要临时变量temp，因此，每轮更新时，将max_second临时存储在temp中。

*/
class Solution {
    public int rob(int[] nums) {
        int max_first = 0;
        int max_second = 0;
        for(int i = 0; i < nums.length; i++){
            int temp = max_second;
            max_second = Math.max(max_second, max_first+nums[i]);
            max_first = temp;
        }
        return max_second;
    }
}