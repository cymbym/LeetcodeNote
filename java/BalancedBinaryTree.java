/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

1.深遍。之前python中选择额外构造一个函数来计算树的深度。然后在主函数中，既递归了深度，又递归了平衡问题，造成空间和时间的浪费。
2.此处在构造的函数中，既判断了深度，同时判断平衡问题，节约了空间和时间。由于java返回值不便，因此选择用数组存储了深度和平衡与否，作为返回值。
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
    public boolean isBalanced(TreeNode root) {
        int depth_val[] = depth(root);
        if(depth_val[1] == 1){
            return false;
        }else{
            return true;
        }
    }
    public int[] depth(TreeNode root) {
        int[] depth_val = {0, 0};
        if(root == null){
            return depth_val;
        }else{
            int[] depth_left = depth(root.left);
            int[] depth_right = depth(root.right);
            depth_val[0] = Math.max(depth_left[0], depth_right[0]) + 1;
            if(Math.abs(depth_left[0]-depth_right[0])>1 || depth_left[1]==1 || depth_right[1]==1){
                depth_val[1] = 1;  
            }
            return depth_val;			
        }
    }
}