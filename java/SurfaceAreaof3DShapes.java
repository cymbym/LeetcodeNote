/*
On a N * N grid, we place some 1 * 1 * 1 cubes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

Return the total surface area of the resulting shapes.

 

Example 1:

Input: [[2]]
Output: 10
Example 2:

Input: [[1,2],[3,4]]
Output: 34
Example 3:

Input: [[1,0],[0,2]]
Output: 16
Example 4:

Input: [[1,1,1],[1,0,1],[1,1,1]]
Output: 32
Example 5:

Input: [[2,2,2],[2,1,2],[2,2,2]]
Output: 46
 

Note:

1 <= N <= 50
0 <= grid[i][j] <= 50

1.看懂题意很重要，如[[2]]，摆一个高为2的积木。
                  如[[1,2],[3,4]]，先摆一个高为1，并列摆一个高为2；换行摆高为3，并列摆高为4。
                  如[[1,1,1],[1,0,1],[1,1,1]]和[[2,2,2],[2,1,2],[2,2,2]]，都是一个凹井。
*/


class Solution {
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid.length; j ++) {
                sum += grid[i][j] * 6;
                if (grid[i][j] > 1) sum -= 2 * (grid[i][j] - 1);
                if (i > 0) sum -= 2 * Math.min(grid[i][j], grid[i - 1][j]);
                if (j > 0) sum -= 2 * Math.min(grid[i][j], grid[i][j - 1]);
            }
        }
        return sum;
    }
}