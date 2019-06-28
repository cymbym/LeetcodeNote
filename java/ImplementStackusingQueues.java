/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

1.投机取巧，没按题意来，用了ArrayList。44ms。
2.用Queue接口。41ms。注意pop()的写法，由于Queue只能输出头部，但我们要挪出尾部。因此在循环里，用拆东墙补西墙的方法，将头部挪至尾部，直至原尾部也挪出。
	还要注意top()，可以利用写好的pop()。


*/

class MyStack {
	private List<Integer>  stack;
    /** Initialize your data structure here. */
    public MyStack() {
        stack = new ArrayList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
		int temp = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
		return temp;
    }
    
    /** Get the top element. */
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.size() == 0;
    }
}


class MyStack {
	private Queue<Integer> queue; 
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
		if(queue.isEmpty()){
			return -1;
		}else{
			int len = queue.size();
			for(int i = 0; i < len - 1; i ++){
				queue.offer(queue.poll());
			}
			return queue.poll();
		}
		
    }
    
    /** Get the top element. */
    public int top() {
		int temp = this.pop();
		queue.offer(temp);
        return temp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */