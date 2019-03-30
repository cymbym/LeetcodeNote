/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

1.斐波那契数列，想用递归的，但是超时了orz……，于是老老实实用迭代了

*/
class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }else{
            //return climbStairs(n - 1) + climbStairs(n - 2); 居然超时了，哭了
            int x = 0, y = 1, z = 2;
            for(int i = 2; i < n; i ++ ){
                x = y + z;
                y = z;
                z = x;
            }
            return x;
        }
    }
}