/*
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps.
 You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].

1.我的解法：用了递归，时间炸了。
2.最优解：用的迭代。每步x都存储两个值：当前步x的最小值+当前步的cost，前一步x-1的最小值+前一步的cost。
						
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return 0;
        else return Math.min(minCostClimbingStairs(Arrays.copyOfRange(cost, 0, cost.length-1)) + cost[cost.length-1], minCostClimbingStairs(Arrays.copyOfRange(cost, 0, cost.length-2)) + cost[cost.length-2]);
    }
}


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int temp_1 = 0;
        int temp_2 = 0;
        for (int i = 0; i < cost.length; i ++) {
            int temp = cost[i] + Math.min(temp_1, temp_2);
            temp_2 = temp_1;
            temp_1 = temp;
        }
        return Math.min(temp_1, temp_2);
    }
}