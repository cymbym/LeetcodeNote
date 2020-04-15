/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 

Example 2:


Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 

Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
 

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.


1.自己的解法是将该问题转化为两个环(A+B 和 B+A)，寻找共同节点。
2.最快的解法是先算得各自的长度，随后对齐尾部，从差值节点开始并进，直至相同节点。
3.1和2的思路进行比较，可以看出1中多走了一部分，是利用两个链表的长度之和，来追上2中的这个差值节点。但其实1还得算长度，不懂为何时间反而快了。



public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        int lenA = 0, lenB = 0, diff = 0;
        
        while(cur != null){
            lenA++;
            cur = cur.next;
            
        }
        cur = headB;
        while(cur !=null){
            lenB++;
            cur = cur.next;
        }
        if(lenA>lenB){
            diff = lenA-lenB;
            for(int i = 0; i<diff; ++i){
                headA = headA.next;
            }
            while(headA !=null){
                if(headA==headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
        }
        else{
            diff = lenB-lenA;
            for(int i = 0; i<diff; ++i){
                headB = headB.next;
            }
            while(headB !=null){
                if(headA==headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
            
        }
        return null;
    }
}
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB){
            tempA = (tempA != null) ? tempA.next : headB;
            tempB = (tempB != null) ? tempB.next : headA;
        }
        return tempA;
    }
}
