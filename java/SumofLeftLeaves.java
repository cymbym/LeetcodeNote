/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

1.采用深遍，一开始觉得很麻烦，后来才发现，只要遍历
	[null],[1，null,null]返回0；
	[1，null,all]返回sumOfLeftLeaves(all)；
	[1，2,all，null,null]返回2+sumOfLeftLeaves(all)。	
	
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return 0;
        }else if(root.left == null){
            return sumOfLeftLeaves(root.right);
        }else if(root.left.left == null && root.left.right == null){
            return root.left.val + sumOfLeftLeaves(root.right);
        }else{
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}