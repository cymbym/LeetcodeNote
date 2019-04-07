"""
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
1.采用层序遍历 / 广遍，将第一层节点存储到nodes_now，随后将nodes_now中每个节点的左右子节点都append()到nodes_next；
2.同时将nodes_now的每个节点的值append()到small中，该层存储完后，将small插入large的头部；
3.随后用nodes_next替换nodes_now，进入下一层。重复执行1~3的步骤。
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        large = []
        if root == None:
            return large
        nodes_now=[root]
        while nodes_now:
            nodes_next = []
            small = []
            for i in nodes_now:
                if i.left:
                    nodes_next.append(i.left)
                if i.right:
                    nodes_next.append(i.right)
                small.append(i.val)
            large.insert(0,small)
            nodes_now = nodes_next
        # large.reverse()
        return large

        
        