/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 

Note: There are at least two nodes in this BST.

1.BST有个性质就是当中序遍历时，得到的值就是按顺序得到的。
2.写了个递归函数，用于存储全局变量数组：前一个结点的值 + 最小差。
*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int[] ans;
    public int getMinimumDifference(TreeNode root) {
        ans = new int[2];
        ans[0] = Integer.MIN_VALUE; //前一个结点的初始化值
        ans[1] = Integer.MAX_VALUE; //最小差值的初始化值
        getPrevMin(root);
        return ans[1];
    }
    private void getPrevMin(TreeNode root) {
        if (root != null) {
            if (root.left != null) getPrevMin(root.left);
            if (ans[0] != Integer.MIN_VALUE) ans[1] = Math.min(ans[1], root.val - ans[0]);
            ans[0] = root.val;
            if (root.right != null) getPrevMin(root.right);
        }
    }
}