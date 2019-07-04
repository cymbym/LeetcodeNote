/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).


1.我的思路是全程用栈来处理（栈底相当于队头），因此主要在于如何写pop()和peek()。
  我是在pop()中，用list存储栈里的数，待输出栈底（队头）后，重新存回栈里。全程更新栈底（队头）元素。
2.答案思路是全程将栈当做队列来使用（栈顶相当于队头）。因此主要在于写push()。
  用一个临时栈s2存储，用s1来作为答案的使用。
	private int front;
	public void push(int x) {
		if (s1.empty())
			front = x;
		while (!s1.isEmpty())
			s2.push(s1.pop());
		s2.push(x);
		while (!s2.isEmpty())
			s1.push(s2.pop());
	}



*/

class MyQueue {
	private Stack<Integer> stack;
	private int top;
	/** Initialize your data structure here. */
	public MyQueue() {
		stack = new Stack<Integer>();
	}
    
	/** Push element x to the back of queue. */
	public void push(int x) {
		if(stack.size() == 0)top = x;
		stack.push(x);
	}
           
	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		int len = stack.size();
		int[] temp = new int[len];
		for(int i = 0; i < len; i ++){
			temp[i] = stack.pop();
		}
		for(int i = len - 2; i >= 0; i --){
			stack.push(temp[i]);
		}
		top = (len >= 2) ? temp[len-2] : top;
		return temp[len-1];
	}
    
	/** Get the front element. */
	public int peek() {
		return top;
	}
    
	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack.empty();
	}
}





/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 
 Input
["MyQueue","push","push","pop","peek"]
[[],[1],[2],[],[]]
Output
[null,null,null,1,1]
Expected
[null,null,null,1,2]