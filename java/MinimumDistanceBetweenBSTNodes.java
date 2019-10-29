/*
Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.

1.BST中序遍历是从大到小！！！！
2.由于是找出任意两结点之间的最小值，而不是相邻，所以需要从小到大遍历。
3.因此存储一个全局变量TreeNode prev;保留前一个结点，对其后续的点不断更新差值。		  
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
    TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        prev = null;
        DFS(root);
        return res;
    }
    public void DFS(TreeNode curr) {
        if (curr.left != null) DFS(curr.left);
        if (prev != null && Math.abs(prev.val - curr.val) < res) res = Math.abs(prev.val - curr.val);
        prev = curr;
        if (curr.right != null) DFS(curr.right);
    }
}