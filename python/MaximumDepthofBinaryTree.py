"""
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

1.深遍，对左右子树使用递归即可。
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        # t = 1
        # if root.left != None or root.right != None:
        #     if root.left != None and root.right == None:
        #         t = t + self.maxDepth(root.left)
        #     elif root.left == None and root.right != None:
        #         t = t + self.maxDepth(root.right)
        #     else:
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
        