"""
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

1.此处额外使用了两个指针来表示，但这个方法不太好，可以参考java的解法，直接对head进行处理
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None:
            return head
        temp = head.val
        result = p = ListNode(-1)
        p.next = head
        p = p.next
        while head.next != None :
            head = head.next
            if head.val != temp:
                p.next = head
                p = p.next
            else:
                p.next = None
            temp = head.val
        return result.next
            