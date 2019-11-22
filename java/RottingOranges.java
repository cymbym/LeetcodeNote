/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

1.采用广度优先遍历：
              a.先将R行C列的方格，映射成逐个的数字1,2,……,R*C，各个位置记为code。
              b.每次都将出现过的2的code存储在queue里，将code和深度存储在map里。
              c.在while中遍历queue直至队列为空，不断按层数poll掉上一层的code、加入新的code，并将1置换为2。
              d.最后重新遍历数组，寻找是否还有1。
2.答案的解法：
              在上述的c中，利用两个数组，在循环中执行遍历其上下左右。
              即：int[] dr = new int[]{-1, 0, 1, 0};
                  int[] dc = new int[]{0, -1, 0, 1};
3.最优解：省略了将code和深度存储在map里，以及省略了d。其做法是一开始就在b中得到了1的数目，且在c中，逐个减去处理了的数目。
          若最后刚好二者抵消，则没有1。
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int R = grid.length;
        int C = grid[0].length;
        for (int r = 0; r < R; r ++) {
            for (int c = 0; c < C; c ++) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.offer(code);
                    map.put(code, 0);
                }
            }
        }
        while (queue.size() != 0) {
            int code = queue.poll();
            int r = code / C;
            int c = code % C;
            if (r + 1 < grid.length) {
                if (grid[r + 1][c] == 1) {
                    res = map.get(code) + 1;
                    int newCode = (r + 1) * C + c;
                    queue.offer(newCode);
                    map.put(newCode, res);
                    grid[r + 1][c] = 2;
                }
            }
            if (c + 1 < grid[0].length) {
                if (grid[r][c + 1] == 1) {
                    res = map.get(code) + 1;
                    int newCode = r * C + (c + 1);
                    queue.offer(newCode);
                    map.put(newCode, res);
                    grid[r][c + 1] = 2;
                }
            }
            if (r - 1 >= 0) {
                if (grid[r - 1][c] == 1) {
                    res = map.get(code) + 1;
                    int newCode = (r - 1) * C + c;
                    queue.offer(newCode);
                    map.put(newCode, res);
                    grid[r - 1][c] = 2;
                }
            }
            if (c - 1 >= 0) {
                if (grid[r][c - 1] == 1) {                    
                    res = map.get(code) + 1;
                    int newCode = r * C + (c - 1);
                    queue.offer(newCode);
                    map.put(newCode, res);
                    grid[r][c - 1] = 2;
                }
            }
        }
        for (int r = 0; r < R; r ++) {
            for (int c = 0; c < C; c ++) {
                if (grid[r][c] == 1) return -1;
            }
        }
        return res;
    }
}


class Solution {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        // queue : all starting cells with rotten oranges
        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;

    }
}



class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        // boolean[] visited = new boolean[rowLen][colLen];
        Queue<int[]> queue = new LinkedList<>();
        int fresh_count = 0, count = 0;
        for(int row = 0; row < rowLen; row++) {
            for(int col = 0; col < colLen; col++) {
                if(grid[row][col] == 2) {
                    queue.add(new int[]{row, col});
                }else if(grid[row][col] == 1) {
                    fresh_count++;
                }
            }
        }
        if(fresh_count == 0) return 0;

        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int pos_x = pos[0];
                int pos_y = pos[1];
                for(int j = 0; j < 4; j++) {
                    int new_pos_x = pos_x + dx[j];
                    int new_pos_y = pos_y + dy[j];
                    
            // if(new_pos_x < 0 || new_pos_y < 0 || new_pos_x >= rowLen || new_pos_y >= colLen || grid[new_pos_x][new_pos_y] == 0 || grid[new_pos_x][new_pos_y] == 2) continue;

                    
                    if(new_pos_x >= 0 && new_pos_x < rowLen && new_pos_y >= 0 && new_pos_y < colLen && grid[new_pos_x][new_pos_y] == 1) {
                        grid[new_pos_x][new_pos_y] = 2;
                        queue.add(new int[]{new_pos_x,new_pos_y});
                        fresh_count--;
                    }
                }
            }
        }
        return fresh_count == 0 ? count -1 : -1;
    }
}