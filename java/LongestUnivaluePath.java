/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

 

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output: 2

 

Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2

 

Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.


1.利用前序遍历，对各个结点的两个子结点去判断其向左或者向右的同值长度的最大值。即UnivaluePath(root.left) 和 UnivaluePath(root.right);
2.随后分别判断该结点和两个子结点是否相等，若相等，更新leftCur 和 rightCur。
3.最后令res等于res 和 leftCur + rightCur 的最大值，UnivaluePath(root)的返回值等于leftCur 和 rightCur 的最大值（与步骤1呼应）。

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
    int res;
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        UnivaluePath(root);
        return res;
    }
    public int UnivaluePath(TreeNode root) {
        if (root == null) return 0;
        else {
            int leftPre = UnivaluePath(root.left);
            int rightPre = UnivaluePath(root.right);
            int leftCur = 0;
            int rightCur = 0;
            if (root.left != null && root.left.val == root.val) leftCur = leftPre + 1;
            if (root.right != null && root.right.val == root.val) rightCur = rightPre + 1;
            res = Math.max(res, leftCur + rightCur);
            return Math.max(leftCur, rightCur);
        }
    }
}