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
1.���ò������ / ��飬����һ��ڵ�洢��nodes_now�����nodes_now��ÿ���ڵ�������ӽڵ㶼append()��nodes_next��
2.ͬʱ��nodes_now��ÿ���ڵ��ֵappend()��small�У��ò�洢��󣬽�small����large��ͷ����
3.�����nodes_next�滻nodes_now��������һ�㡣�ظ�ִ��1~3�Ĳ��衣
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

        
        