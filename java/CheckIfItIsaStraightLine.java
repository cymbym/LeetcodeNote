/*
You are given an array coordinates, coordinates[i] = [x, y],
 where [x, y] represents the coordinate of a point.
 Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.

1.判断数组是否在一条线上，先判断是否平行于x轴；再用y=kx+b判断。
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates[1][0] == coordinates[0][0]) {
            for (int i = 2; i < coordinates.length; i ++) {
                if (coordinates[i][0] != coordinates[0][0]) return false;
            }
        } else {
            int k = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
            int b = coordinates[0][1] - k * coordinates[0][0];
            for (int i = 2; i < coordinates.length; i ++) {
                if (coordinates[i][1] != k * coordinates[i][0] + b) return false;
            }
        }
        return true;
    }
}