/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

1.深遍，对左右子树使用递归即可。
2.原本不想直接用Math.max(),便用三目运算符写了个判断式，结果却超时了？？用Math.max()反而通过了emmmm
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
    public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }else{
//             return maxDepth(root.left) > maxDepth(root.right) ?
// maxDepth(root.left) + 1 : maxDepth(root.right) + 1;  
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;  
    }
}