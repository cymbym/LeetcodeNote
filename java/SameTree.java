/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

1.采用深度优先遍历，先判断俩左右子节点，随后采用递归，判断俩左右子树，深入探索一波
PS:深遍是用左右子树递归处理，广遍则逐层判断左右子节点
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            if(p == null && q == null){
                return true;
            }else{
                return false;
            }
        }else{
            if(p.val != q.val){
                return false;
            }else{
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}