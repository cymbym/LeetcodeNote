/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

1.直接对原始的head指针进行操作：将head的值与head.next的值比较，若不同则head指向的地址后延，若相同则head.next的地址后延
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode p = head;
        while(p != null && p.next != null){
            if( p.next.val != p.val){
                p = p.next;
            }else{
                p.next = p.next.next;
            }
        }
        return head;
    }
}