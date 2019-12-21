/*
A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.

The bus goes along both directions i.e. clockwise and counterclockwise.

Return the shortest distance between the given start and destination stops.

 

Example 1:



Input: distance = [1,2,3,4], start = 0, destination = 1
Output: 1
Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 

Example 2:



Input: distance = [1,2,3,4], start = 0, destination = 2
Output: 3
Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
 

Example 3:



Input: distance = [1,2,3,4], start = 0, destination = 3
Output: 4
Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
 

Constraints:

1 <= n <= 10^4
distance.length == n
0 <= start, destination < n
0 <= distance[i] <= 10^4


1.a点到b点的距离有两种可能性，正序和逆序。
  因此可以考虑统计所有和，得到正序和，此时逆序和等于所有和减去正序和。
2.可以在一次循环里挨个获取部分和。较大的部分和减去较小的部分和，即为得到的正序和。
3.还需注意把start更新为较小的地点，destination更新为较大的地点。

*/

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        int[] sumMap = new int[distance.length + 1];
        for (int i = 0; i < distance.length; i ++) {
            sum += distance[i];
            sumMap[i + 1] = sum;
        }
        int head = Math.min(start, destination);
        int tail = start + destination - head;
        int tmp = sumMap[tail] - sumMap[head];
        return Math.min(tmp, sum - tmp);
    }
}