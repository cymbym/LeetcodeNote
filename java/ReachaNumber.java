/*
You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.

Example 1:
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
Example 2:
Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.
Note:
target will be a non-zero integer in the range [-10^9, 10^9].

1.我的解法：把每一步可能的结果都列出来，会发现该步的最大和sum：
              如果能包含target，且与target同奇偶，则该步数为所得；
                                若与target不同奇偶，则该步加上1 + i % 2后，得到的sum与target同奇偶，此时新步数为所得。 1ms。
2.最优解：直接利用target = i * (i + 1) / 2，找到包含target的sum和对应的i，利用求根公式：i = (-1 + sqrt(1 + 8*target)) / 2。
              后同我的解法。 0ms。

*/

class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
		int i = 1;
        int sum = i;
        while (sum < target) {
            i ++;
            sum += i;
        }
        if ((sum - target) % 2 == 0) return i;
        else return i + 1 + i % 2; 
    }
}

class Solution {
    public int reachNumber(int target) {
        long Target = Math.abs(target);
        int i = (int)Math.ceil((Math.sqrt(8 * Target + 1) - 1) / 2);
        long sum = i * (i + 1) / 2;
        // if (((sum - Target) & 1) == 0) return i;
        if ((sum - Target) % 2 == 0) return i;
        else return i + 1 + i % 2;
    }
}