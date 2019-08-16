/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

1.采用后序遍历，获取左右子树深度，得到该结点深度。
2.同时实时更新最大路径：res = Math.max(res, temp1 + temp2);。
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
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        getDepth(root);
        return res;
    }
    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int temp1 = getDepth(root.left);
            int temp2 = getDepth(root.right);
            res = Math.max(res, temp1 + temp2);
            return Math.max(temp1, temp2) + 1;
        }
    }
}