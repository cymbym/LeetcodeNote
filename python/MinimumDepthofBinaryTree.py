"""
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

1.深遍。对子节点用递归。
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.depth(root)
    
    def depth(self, root):
        if not root:
            return 0
        elif not root.left and not root.right:
            return 1
        elif not root.left or not root.right:
            return max(self.depth(root.left), self.depth(root.right)) + 1
        else:
            return min(self.depth(root.left), self.depth(root.right)) + 1