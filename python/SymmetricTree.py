"""
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

1.第一反映是想到用递归，但是用去啥递归，显然直接用左右子树是不行的。
2.解题关键：p.left = l.left
            p.right = r.right
            q.left = l.right
            q.right = r.left
	由于该问题是对称问题，因此利用左节点的左枝与右节点的右枝构造树p，左节点的右枝与右节点的左枝构造树q，分别判断p、q即可

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return True
        l = root.left
        r = root.right
        if l == None or r == None:
            if not( l == None and r == None ):
                return False
            else:
                return True
        if l.val == r.val:
            p = TreeNode(-1)
            q = TreeNode(-1)
            p.left = l.left
            p.right = r.right
            q.left = l.right
            q.right = r.left            
            if self.isSymmetric(p):
                return self.isSymmetric(q)
            else:
                return False
        return False