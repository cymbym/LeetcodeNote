/*
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.

Example 1:

Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
 

Example 2:

Input: 3
Output: False

1.我：直接用两个数遍历，一个递增，一个开根号得到。4ms。
2.最优解：费马平方和定理的一般推广形式：即当某个数字的 4k+3 型的质数因子的个数均为偶数时，其可以拆分为两个平方数之和。
		  so只要统计其每个质数因子的个数，并且判断：若其为 4k+3 型且出现次数为奇数的话直接返回 false。
		  这里，我们从2开始遍历，若能整除2，则计数器加1，并且c也要除以2。这样我们找到所有质数因子。
		  最终在循环退出后，我们还要再判断一下，若剩余的质数因子还是个 4k+3 型，那么返回 false，否则返回 true。
*/

class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = c;
        while (a <= b) {
            int temp = c - a * a;
            b = (int)Math.sqrt(temp);
            if (temp == b * b) return true;
            else a ++;
        }
        return false;
    }
}

class Solution {
    public boolean judgeSquareSum(int c) {
        int n = c;
        for (int i = 2; i * i <= n; i++) { 
            int count = 0; 
            if (n % i == 0) { 
                while (n % i == 0) { 
                    count++; 
                    n /= i; 
                } 
                if (i % 4 == 3 && count % 2 != 0) return false; 
            } 
        } 
        return n % 4 != 3;    
    }
}