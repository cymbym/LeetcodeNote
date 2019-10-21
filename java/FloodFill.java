/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel,
 plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
 Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].	

1.我的解法：首先，建立两个数组，分别存储返回的结果int[][] res和是否遍历过该点boolean[][] pass。 1ms。
            接着，对原数组采用深度遍历，从初始点起，如果该点的值是oldValue且没有更新过，则可依次利用迭代，往上下左右进行遍历。
                                        同时利用四个方向变量，避免走回头路（即若此时向up走，则下一次迭代中的down为false）。
2.最优解：没有用到方向。因为在fill里，一开始就判断了image[sr][sc] != color，因此那些更新过的值直接忽略。		  
						
*/

class Solution {
    int[][] res;
    boolean[][] pass;
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        else {
            res = image;
            pass = new boolean[image.length][image[0].length];
            oldColor = image[sr][sc];
            fill(image, sr, sc, newColor, true, true, true, true);
            return res;
        }
    }
    public void fill(int[][] image, int sr, int sc, int newColor, boolean left, boolean right, boolean up, boolean down) {
        if (res[sr][sc] == oldColor && !pass[sr][sc]) {
            res[sr][sc] = newColor;
            pass[sr][sc] = true;
            if (up && sr - 1 >= 0) fill(image, sr - 1, sc, newColor, true, true, true, false);
            if (down && sr + 1 < image.length) fill(image, sr + 1, sc, newColor, true, true, false, true);
            if (left && sc - 1 >= 0) fill(image, sr, sc - 1, newColor, true, false, true, true);
            if (right && sc + 1 < image[0].length) fill(image, sr, sc + 1, newColor, false, true, true, true);
        }
        return;
    }
}


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //base case
        if(image[sr][sc] == newColor){
            return image;
        }
        //helper dfs function
        fill(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    
    public void fill(int[][] image, int sr, int sc,int color,int newColor){
        //boundary checks 
        if(sr<0 || sc<0 || sr>= image.length || sc>=image[0].length || image[sr][sc] != color){
            return ;
        
        }
        image[sr][sc] = newColor;
        
        fill(image,sr-1,sc,color,newColor);
        fill(image,sr+1,sc,color,newColor);
        fill(image,sr,sc-1,color,newColor);
        fill(image,sr,sc+1,color,newColor);
    }
}