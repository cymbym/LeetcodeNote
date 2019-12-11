/*
Given a binary tree, each node has value 0 or 1.
  Each root-to-leaf path represents a binary number starting with the most significant bit.
  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

 

Example 1:



Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 

Note:

The number of nodes in the tree is between 1 and 1000.
node.val is 0 or 1.
The answer will not exceed 2^31 - 1.

1.采用前序遍历，全局变量sum记录所求总和，局部变量pre记录根结点到该结点之前的部分路径和。
                当遍历到叶子结点时，返回总和。
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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return sum;
        else {
            int pre = 0;
            order(root, pre);
            return sum;
        }
    }
    public void order(TreeNode root, int pre) {
        if (root == null) return;
        else {
            pre = pre * 2 + root.val;
            if (root.left == null && root.right == null) sum += pre;
            else {
                order(root.left, pre);
                order(root.right, pre);
            }
            return;
        }
    }
}