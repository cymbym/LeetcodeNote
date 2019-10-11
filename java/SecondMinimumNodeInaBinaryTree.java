/*
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
 

Example 2:

Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.

1.采用前序遍历。
    初始化最小值和次小值为Integer.MAX_VALUE，分两种情况更新最小值和次小值：
    该数小于最小值，直接更新最小值和次小值；
	该数小于次小值且不等于最小值，更新次小值，且一旦次小值产生过替换，标志flag也更新（以防次小值是Integer.MAX_VALUE）。
	
	随后对左右子结点分别遍历……

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
    int res = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    boolean flag = true;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return res == min ? -1 : res;
        else {
            if (root.val < min) {
                res = min;
                min = root.val;
            } else if (root.val <= res && root.val != min) {
                flag = false;
                res = root.val;
            }
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
            if (res == min || flag) return -1;
            else return res;
        }
    }
}