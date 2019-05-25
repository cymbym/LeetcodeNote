/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

1.使用迭代：一个存储各递增区间最小值，作为一个flag在数组中游走；一个存储最大利益，通过更迭，保留各递增区间累积最大值。
2.在买卖股票的两个问题中，第一个问题只售卖一次，关键在于更新最小值，比较实时的最大值。[7,1,5,3,6,4]->[1,6]
                          第二个问题可售卖多次，关键在于寻找出多个递增区间，利用区间更新最小值，累加实时的最大值。[7,1,5,3,6,4]->[1,5]，[3,6]
*/

class Solution {
    public int maxProfit(int[] prices) {
		if(prices.length == 0){
            return 0;
        }else{
            int max = 0;
            int min = prices[0];
            int len = prices.length;
            for(int i = 1; i < len; i ++){
                if(prices[i-1] > prices[i]){
					max = max + prices[i-1] - min;
					min = prices[i];
				} 
            }
            if(len >= 2 && prices[len-2] <= prices[len-1]){
					max = max + prices[len-1] - min;
				} 
            return max;
        }
    }
}