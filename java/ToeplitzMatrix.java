/*
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 

Example 1:

Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:

Input:
matrix = [
  [1,2],
  [2,2]
]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.

Note:

matrix will be a 2D array of integers.
matrix will have a number of rows and columns in range [1, 20].
matrix[i][j] will be integers in range [0, 99].

Follow up:

What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
What if the matrix is so large that you can only load up a partial row into the memory at once?

1.挨个列举，寻找规律。如3行4列数组。就是(2,0);  (2,1),(1,0);   (2,2),(1,1),(0,0);   (2,3),(1,2),(0,1);   (1,3),(0,2);  (0,3)	
2.规律：起始点(matrix.length - 1, 0)，对应差值为matrix.length - 1；
        中间各个点的初始行一直是matrix.length - 1，差值递减，直至列出现matrix[0].length - 1，则行的上限也开始减小；
		终止点(0, matrix[0].length - 1)，对应差值为1 - matrix[0].length。
*/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length - 1;
        int c = 0;
        for (int diff = matrix.length - 1; diff >= 1 - matrix[0].length; diff --) {
            int i = r;
            int j = i - diff;
            if (j >= matrix[0].length - 1) r --;
            while (i - 1 >= 0 && j - 1 >= 0) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
                i --;
                j --;
            }
        }
        return true;
    }
}