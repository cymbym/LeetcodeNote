"""
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

1.这道题很好地学习了python中链表和类的用法
2.注意空的时候用None，和初始化时用-1
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        p = ListNode(-1)
        l0 = p
        while l1 != None and l2 != None:
        # while l1 and l2 :
            if l1.val <= l2.val:
                l0.next = l1
                l1 = l1.next
            else:
                l0.next = l2
                l2 = l2.next
            l0 = l0.next
        if l1 != None:
            l0.next = l1
        else:
            l0.next = l2
        return p.next