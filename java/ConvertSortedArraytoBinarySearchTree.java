/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 
1.采用深遍，取中点作为根节点，取数组前半部分和后半部分分别用递归来构造根节点的左右子树
2.注意java数组的截取得构造新数组，例如System.arraycopy()，此外注意截取的范围，上下限都要考虑到【此处就凸显python数组的便捷了
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }else if(nums.length == 1){
            TreeNode root = new TreeNode(nums[0]);
            return root;
        }else{
            TreeNode root = new TreeNode(nums[nums.length / 2]);
            int[] numsL = new int[nums.length / 2], numsR = new int[nums.length / 2];
            System.arraycopy(nums, 0, numsL, 0, nums.length / 2);
            root.left = sortedArrayToBST(numsL);
            System.arraycopy(nums, nums.length / 2 + 1, numsR, 0, nums.length - nums.length / 2 - 1);
            root.right = sortedArrayToBST(numsR);
            return root;
        }
        
    }
}
 