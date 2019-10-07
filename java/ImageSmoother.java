/*
Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
The value in the given matrix is in the range of [0, 255].
The length and width of the given matrix are in the range of [1, 150].

1.题意是将该数周围的和数除以周围的个数。
*/

class Solution {
    int[][] res;
    public int[][] imageSmoother(int[][] M) {
        res = new int[M.length][M[0].length];
        for(int i = 0; i < M.length; i ++) {
            for(int j = 0; j < M[0].length; j ++) {
                res[i][j] = value(M, i, j);
            }
        }
        return res;
    }
    public int value(int[][] M, int i, int j) {
        int sum = 0;
        int cnt = 0;
        for(int s = -1; s < 2; s ++) {
            for(int t = -1; t < 2; t ++) {
                if (i + s >= 0 && j + t >= 0 && i + s < M.length && j + t < M[0].length) {
                    sum += M[i + s][j + t];
                    cnt ++;
                }
            }
        }
        return sum / cnt;
    }
}