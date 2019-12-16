/*
We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose the two heaviest rocks and smash them together.
  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 

Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000

1.将所有数及其出现次数存储到数组中。
2.从大到小遍历该数组。若某数出现两次，则计数器减2次；同时更新数组。
                      若某数出现一次，则找到下一个数，计数器减1次；同时更新数组。
3.当计数器只剩一次或零次后，输出对应的数或0。
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        else {
            int[] map = new int[1001];
            for (int s: stones) map[s] ++;
            int i = 1000;
            int maxBig = 0;
            int maxSma = 0;
            int cnt = stones.length;
            while (i > 0) {
                if (cnt > 1) {
                    if (map[i] >= 2) {
                        map[i] -= 2;
                        cnt -= 2;
                    }
                    else if (map[i] > 0) {
                        maxBig = i;
                        map[i --] --;
                        while (i >= 0 && map[i] == 0) i --;
                        maxSma = i;
                        map[i] --;
                        map[maxBig - maxSma] ++;
                        cnt --;
                        i = Math.max(i, maxBig - maxSma);
                    } else i --;
                } else if (cnt == 1) {
                    while (map[i] == 0) i --;
                    return i;
                } else return 0;
            }
            return 0;
        }
    }
}