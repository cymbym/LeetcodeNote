/*
Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
 
 
 1.在前序遍历中，进行区间的判断。该结点非null时，分三种情况：
   若在区间内，则直接将root值分配给res，再对左结点和右结点进行遍历赋值；
   若在区间外，利用BST的性质，根据大于或者小于，将左结点或者右结点进行遍历赋值。
2.注意res的定义和声明方法。
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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        else {
            if (root.val >= L && root.val <= R) {
                TreeNode res = new TreeNode(root.val);
                res.left = trimBST(root.left, L, R);
                res.right = trimBST(root.right, L, R);
                return res;
            }
            else if (root.val < L) {
                 TreeNode res;
                 res = trimBST(root.right, L, R);
                return res;
            }
            else if (root.val > R) {
                TreeNode res;
                res = trimBST(root.left, L, R);
                return res;
            }
            return null;   
        }
    }
}