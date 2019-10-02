/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False


1.我的解法：在前序遍历中利用HashSet找出所要找的值，没有利用到二叉搜索树的性质。4ms。
2.最优解：利用二叉搜索树的性质，每个结点都只往较大或者较小处去遍历。1ms。
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
    HashSet set = new HashSet();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        else {
            return order(root, k);
        }
    }
    public boolean order(TreeNode root, int k) {
        if(root == null) return false;
        else {
            if(set.contains(k - root.val)) return true;
            else {
                set.add(root.val);
                return order(root.left, k) || order(root.right, k);
            }
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return find(root, root, k);
    }
    
    private boolean find(TreeNode root, TreeNode current, int k){
        if(current == null) return false;
        else {
            if(findVal(root, k-current.val, current)) return true;
        }
        return find(root, current.left, k) || find(root, current.right, k);
    }
    
    private boolean findVal(TreeNode root, int val, TreeNode duplicate){
        if(root == null) return false;
        if(root.val == val && root != duplicate) return true;
        if(root.val > val) return findVal(root.left, val, duplicate);
        return findVal(root.right, val, duplicate);
    }
}