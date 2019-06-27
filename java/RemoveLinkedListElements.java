/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

1.注意对p赋值和对p.next赋值的区别：前者是指针的移动，不影响head；后者是指针的改动，会影响head。
2.因此，想要跳过某个节点，必须更改p.next，从下个节点跳到下下个节点。也因此，做判断的值是下个节点（不能是本节点），也就是p.next.val。
3.由于本节点不能跳过，因此，倘若一开始本节点就是val，想要移动本节点，就应该直接对head进行移动。

*/


 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null) return head;
        ListNode p = head;
        while(p != null && p.next != null){
            if(p.next.val == val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;
    }
}