/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?

1.首先寻找到中间点，生成前部和后部。
2.将前部逆序。
3.对新前部和后部同时比较。

ps:最快的方法是将1和2写到一起，一次完成，但这样就需要多个全局变量。无法满足O(1)的空间。


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
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }else{
            ListNode mid = findMid(head);
            mid = reverseList(mid);
            while(head != null && mid != null){
                if(head.val != mid.val)return false;
                head = head.next;
                mid = mid.next;
            }
            return true;
        }
    }
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}


class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast_ptr = head, slow_ptr = head, prev = null;
    	
        //finding the middle node
        while(fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            ListNode slow_next = slow_ptr.next;
            slow_ptr.next = prev;
            prev = slow_ptr;
            slow_ptr = slow_next;
        }
        //if the list is odd length
        if(fast_ptr != null)
            slow_ptr = slow_ptr.next;
        ListNode comp_ptr = prev;
        while(slow_ptr != null) {
            if(comp_ptr.val != slow_ptr.val)
                return false;
            slow_ptr = slow_ptr.next;
            comp_ptr = comp_ptr.next;
        }
        return true;  
    }
}
