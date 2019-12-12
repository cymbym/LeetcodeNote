/*
There are 2N people a company is planning to interview.
 The cost of flying the i-th person to city A is costs[i][0],
 and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 

Note:

1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000


1.利用两个城市的差将数据分为两组：A城市越小，就存储A城市的值；B城市越小，就存储B城市的值。
  此时一定是最小的sum。否则，任意交换两个城市，增加的cost刚好为之前分出的差所增加的部分。
*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        for (int i = 0; i < costs.length; i ++) {
            for (int j = 0; j < costs.length - i - 1; j ++) {
                if (costs[j][1] - costs[j][0] > costs[j + 1][1] - costs[j + 1][0]) {
                    int tmp0 = costs[j][0];
                    int tmp1 = costs[j][1];
                    costs[j][0] = costs[j + 1][0];
                    costs[j][1] = costs[j + 1][1]; 
                    costs[j + 1][0] = tmp0;
                    costs[j + 1][1] = tmp1;
                }
            }
            if (i < costs.length / 2) sum += costs[costs.length - i - 1][0];
            else sum += costs[costs.length - i - 1][1];
        }
        return sum;   
    }
}