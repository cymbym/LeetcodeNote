/*
We are given a matrix with R rows and C columns has cells with integer coordinates (r, c),
 where 0 <= r < R and 0 <= c < C.

Additionally, we are given a cell in that matrix with coordinates (r0, c0).

Return the coordinates of all cells in the matrix,
 sorted by their distance from (r0, c0) from smallest distance to largest distance.
 Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance,
 |r1 - r2| + |c1 - c2|.
 (You may return the answer in any order that satisfies this condition.)

 

Example 1:

Input: R = 1, C = 2, r0 = 0, c0 = 0
Output: [[0,0],[0,1]]
Explanation: The distances from (r0, c0) to other cells are: [0,1]
Example 2:

Input: R = 2, C = 2, r0 = 0, c0 = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
Example 3:

Input: R = 2, C = 3, r0 = 1, c0 = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
There are other answers that would also be accepted as correct,
 such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 

Note:

1 <= R <= 100
1 <= C <= 100
0 <= r0 < R
0 <= c0 < C


1.我的解法：首先注意深度最大值和R、r0、C、c0之间的关系；注意满足题意的答案共有R*C个。
            将深度从0到最大值去递进，每一层都更新r和c的值，分别加减深度。
            将加减后的值用界限去判断是否添加到答案中。
*/

class Solution {
    int[][] res;
    int cnt;
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        res = new int[R * C][];
        cnt = 0;
        int r = r0;
        int c = c0;
        int depth = 0;
        addCell(R, C, r, c, new int[]{0, 0});
        outerloop:  
        while (depth <= Math.max(R - r0 - 1, r0) + Math.max(C - c0 - 1, c0)) {
            depth ++;
            int[][] vec0 = new int[][]{{0, depth}, {0, -depth}};
            for (int[] k: vec0) addCell(R, C, r, c, k);
            for (int i = 1; i < depth; i ++) {
                int j = depth - i;
                int[][] vec1 = new int[][]{{i, j}, {i, -j}, {-i, j}, {-i, -j}};
                for (int[] k: vec1) addCell(R, C, r, c, k);
            }
            vec0 = new int[][]{{depth, 0}, {-depth, 0}};
            for (int[] k: vec0) addCell(R, C, r, c, k);
        }    
        return res;
    }
    public void addCell(int R, int C, int r, int c, int[] vector) {
        r += vector[0];
        c += vector[1];
        if (r < R && r >= 0 && c < C && c >= 0) {
            int[] tmp = new int[2];
            tmp[0] = r;
            tmp[1] = c;
            res[cnt ++] = tmp;
        }
    }
}