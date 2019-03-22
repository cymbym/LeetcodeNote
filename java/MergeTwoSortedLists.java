/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

1.这道题很好地学习了java中链表和类的用法
2.注意空的时候用null，和初始化时用-1
*/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l0 = new ListNode(-1);
        ListNode p = l0;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l0.next = l1;
                l1 = l1.next;
            }else{
                l0.next = l2;
                l2 = l2.next;
            }
            l0 = l0.next;
        }
        l0.next = (l1 != null) ? l1:l2;
        return p.next;
    }
}