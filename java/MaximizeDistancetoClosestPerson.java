/*
In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Note:

1 <= seats.length <= 20000
seats contains only 0s or 1s, at least one 0, and at least one 1.


1.一开始找到第一个为1的数。其之前所有0视为res（【以0开头】）。
2.跳过这个为1的数，开始判断【被两个1夹】的坐法：若出现0，则不断递增cnt；若出现1，且前一个为0，则根据cnt的一半更新res。
3.最后根据cnt更新res（【以0结尾】）。
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int index = 0;
        int cnt = 0;
        int res = 0;
        while (index < seats.length && seats[index] == 0) {
            index ++;
            res ++;
        }
        index ++;
        while (index < seats.length) {
            if (seats[index] == 1) {
                if (seats[index - 1] != 1) {
                    int tmp = (cnt + 1) / 2;
                    cnt = 0;
                    if (res < tmp) res = tmp;
                }
            } else cnt ++;
            index ++;
        }
        return res < cnt ? cnt : res;
    }
}