/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.


1.采用深遍。将左右子结点用递归逆转方向。

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
    public TreeNode invertTree(TreeNode root) {
		LinkedList<TreeNode> node_curr = new LinkedList<TreeNode>();
		if(root == null || (root.left == null && root.right == null)){
			return root;
		}else{
			TreeNode temp = root.left;
			root.left = root.right;
			root.right= temp;
			root.left = invertTree(root.left);
			root.right = invertTree(root.right);
			return root;
		}
    }
}