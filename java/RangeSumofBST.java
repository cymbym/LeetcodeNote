/*
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

 

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
 

Note:

The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.

1.我的解法：看到BST就想着中序遍历，然后对根做判断。1ms。
2.最优解：其实只需判断，根是不是在这个区间里，便可以讨论要不要对根做存储、对根的左右结点做递归。0ms。
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
    public int rangeSumBST(TreeNode root, int L, int R) {
        res = 0;
        order(root, L, R);
        return res;
    }
    public void order(TreeNode root, int L, int R) {
        if (root == null) return;
        else {
            order(root.left, L, R);
            if (root.val > R) return;
            else if (root.val >= L && root.val <= R) res += root.val;
            order(root.right, L, R);
        }
    }
}

class Solution {
    int ans = 0;
    public int rangeSumBST(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                rangeSumBST(node.left, L, R);
            if (node.val < R)
                rangeSumBST(node.right, L, R);
        }
        return ans;
    }
}