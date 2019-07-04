/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

1.初始化：curr为head，prev为null
2.第一步：curr.next改为prev，即curr从【1->2->3->4->5->NULL】改为【1->NULL】，赋给prev后，curr回到本步初始的curr.next；
3.第二步：curr.next改为prev，即curr从【2->3->4->5->NULL】改为【2->1->NULL】，赋给prev后，curr回到本步初始的curr.next；
4.第三步：curr.next改为prev，即curr从【3->4->5->NULL】改为【3->2->1->NULL】，赋给prev后，curr回到本步初始的curr.next；
……


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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next; //不能等于curr，因为后面curr会变动，temp.next会随着curr.next变动
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
