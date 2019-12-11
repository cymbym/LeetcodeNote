/*
In a list of songs, the i-th song has a duration of time[i] seconds. 

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
  Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 

Note:

1 <= time.length <= 60000
1 <= time[i] <= 500

1.先把所有余数的个数存储起来，注意1~29是能和59~31两两配对的，直接相乘后记录即可。
                              0和30比较特殊，只是组合，不是排列。
*/


class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remind = new int[60];
        int res = 0;
        for (int t: time) remind[t % 60] ++;
        res += remind[0] * (remind[0] - 1) / 2;
        for (int i = 1; i < 30; i ++) res += remind[i] * remind[60 - i];
        res += remind[30] * (remind[30] - 1) / 2;
        return res;
    }
}