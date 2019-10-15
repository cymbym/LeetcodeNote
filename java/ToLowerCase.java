/*
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"


1.注意大写的char为65-90，小写为97-122。
2.String->char[]:String.toCharArray()。
3.char[]->String：new String(char[])。
*/

class Solution {
    public String toLowerCase(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i ++) {
            if ((int)c[i] >= 65 && (int)c[i] <= 90) c[i] += 32;
        }
        return new String(c);
    }
}
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */