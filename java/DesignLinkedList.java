/*
Design your implementation of the linked list.
 You can choose to use the singly linked list or the doubly linked list.
 A node in a singly linked list should have two attributes: val and next.
 val is the value of the current node, and next is a pointer/reference to the next node.
 If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list.
 Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list.
             If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list.
                 After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list.
                         If index equals to the length of linked list, the node will be appended to the end of linked list.
						 If index is greater than the length, the node will not be inserted.
						 If index is negative, the node will be inserted at the head of the list.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
Example:

MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
linkedList.get(1);            // returns 2
linkedList.deleteAtIndex(1);  // now the linked list is 1->3
linkedList.get(1);            // returns 3
Note:

All values will be in the range of [1, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in LinkedList library.

1.我的解法：构造public class ListNode类，定义head、tail，构成【head - MyLinkedList - tail】的组合，其中index只和MyLinkedList有关。67ms。
            get：遍历到index所在位置。
			addAtHead和addAtTail：分别利用head和tail。
			addAtIndex和deleteAtIndex：遍历到index前一个位置。
			
2.最优解：构造函数相同，addAtHead和addAtTail相同。get,addAtIndex和deleteAtIndex根据index和长度的关系，分别从前和后遍历。52ms。
*/

public class ListNode {
    int val;
    ListNode prev;
    ListNode next;
    ListNode(int x) {val = x;}
}
class MyLinkedList {
    ListNode head;
    ListNode tail;
    int len;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        len = 0;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > len) return -1;
        else {
            ListNode curr = head;
            for (int i = 0; i <= index; i ++) {
                curr = curr.next;
            }
            return curr.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        ListNode curr = head.next;
        temp.next = curr;
        temp.prev = head;
        head.next = temp;
        curr.prev = temp;
        len ++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode temp = new ListNode(val);
        ListNode curr = tail.prev;
        temp.prev = curr;
        temp.next = tail;
        tail.prev = temp;
        curr.next = temp;
        len ++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > len) return;
        else {
            if (index < 0) index = 0;
            ListNode curr = head;
            for (int i = 0; i < index; i ++) {
                curr = curr.next;
            }
            ListNode temp = new ListNode(val);
            temp.next = curr.next;
            temp.prev = curr;
            curr.next = temp;
            curr = curr.next.next;
            curr.prev = temp;
            len ++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        System.out.println(index);System.out.println(len);
        if (index < 0 || index >= len) return;
        else if (index == len - 1) {
            ListNode curr = tail.prev.prev;
            curr.next = tail;
            tail.prev = curr;
            len --;
        }
        else {
            ListNode curr = head;
            for (int i = 0; i < index; i ++) {
                curr = curr.next;
                
            } 
            ListNode temp = curr;
            curr.next = curr.next.next;
            curr = curr.next;
            curr.prev = temp;
            len --;
        }
    }
}




public class ListNode {
    int val;
    ListNode prev;
    ListNode next;
    ListNode(int x) {val = x;}
}
class MyLinkedList {
    ListNode head;
    ListNode tail;
    int len;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        len = 0;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > len) return -1;
        else {
            ListNode curr;
            if (index < len / 2) {
                curr = head;
                for (int i = 0; i <= index; i ++) curr = curr.next;
            } else {
                curr = tail;
                for (int i = 0; i < len - index; i ++) curr = curr.prev;
            }
            return curr.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        ListNode curr = head.next;
        temp.next = curr;
        temp.prev = head;
        head.next = temp;
        curr.prev = temp;
        len ++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode temp = new ListNode(val);
        ListNode curr = tail.prev;
        temp.prev = curr;
        temp.next = tail;
        tail.prev = temp;
        curr.next = temp;
        len ++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > len) return;
        else {
            if (index < 0) index = 0;
            ListNode curr;
            if (index < len / 2) {
                curr = head;
                for (int i = 0; i < index; i ++) curr = curr.next;
            } else {
                curr = tail;
                for (int i = 0; i <= len - index; i ++) curr = curr.prev;
            }
            ListNode temp = new ListNode(val);
            temp.next = curr.next;
            temp.prev = curr;
            curr.next = temp;
            curr = curr.next.next;
            curr.prev = temp;
            len ++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) return;
        else if (index == len - 1) {
            ListNode curr = tail.prev.prev;
            curr.next = tail;
            tail.prev = curr;
            len --;
        }
        else {
            ListNode curr;
            if (index < len / 2) {
                curr = head;
                for (int i = 0; i < index; i ++) curr = curr.next;
            } else {
                curr = tail;
                for (int i = 0; i <= len - index; i ++) curr = curr.prev;
            }
            ListNode temp = curr.next.next;
            curr.next = temp;
            temp.prev = curr;
            len --;
        }
    }
}



/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */