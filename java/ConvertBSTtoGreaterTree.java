/*
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

		  
1.由于是BST，采用反向的中序遍历更新树，使用数组存储全局变量：结点和。
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
    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = 0;
        toGreater(root, sum);
        return root;
    }
    private void toGreater(TreeNode root, int[] sum) {
        if (root == null) return;
        else {
            toGreater(root.right, sum);
            sum[0] += root.val;
            root.val = sum[0];
            toGreater(root.left, sum);            
            return;
        }
    }
}

