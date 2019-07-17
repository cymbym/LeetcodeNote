/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:

1.先统计方块个数，随后统计邻边数。所求 = 方块数 * 4 - 邻边数 * 2

*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int redun = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    count ++;
                    if (i - 1 >= 0) {
                        if (grid[i - 1][j] == 1) {
                            redun ++;
                        }
                    }
                    if (i + 1 < grid.length) {
                        if (grid[i + 1][j] == 1) {
                            redun ++;
                        }
                    }
                    if (j - 1 >= 0) {
                        if (grid[i][j - 1] == 1) {
                            redun ++;
                        }
                    }
                    if (j + 1 < grid[0].length) {
                        if (grid[i][j + 1] == 1) {
                            redun ++;
                        }
                    }
                    
                }
            }
        }
        return count * 4 - redun;
    }
}