"""
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
2.不得不感慨python截取数组的便捷orz
 """
 
 # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if nums == []:
            return None
        length = len(nums)
        if length == 1:
            root = TreeNode(nums[0])
            return root
        root = TreeNode(nums[length//2])
        root.left = self.sortedArrayToBST(nums[:length//2])
        root.right = self.sortedArrayToBST(nums[length//2 + 1:])
        
        return root