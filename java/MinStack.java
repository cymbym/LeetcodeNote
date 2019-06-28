/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.



1.��һ�ַ���͵��������ArrayList�е�add(),remove(),get(),�Լ�Collections.min()������ʱ��Ϳռ䶼���ĺܴ�
2.�ڶ��ַ����ԹԵ������������в�����������ʱ��Ϳռ���Դ��ע�⣬��push()��pop()�оͿ�ʼ�洢min��ֵ�ˡ�

*/

class MinStack {
	private List<Integer> stack; 
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<Integer>(); 
    }
    
    public void push(int x) {
        stack.add(x);
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
        
    }
    
    public int getMin() {
        return Collections.min(stack);
    }
}


class MinStack {
	private int[] stack = new int[10000]; 
    private int num = 0;
    private int min = 0x7fffffff;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack[num] = x;
        num ++;
        min = (min<=x)?min:x;
    }
    
    public void pop() {
        if(stack[num-1] == min){
            min = 0x7fffffff;
            for(int i = 0; i < num - 1; i ++){
                min = (min<stack[i])?min:stack[i];
            }
        }
        num --;
    }
    
    public int top() {
        return stack[num-1];
    }
    
    public int getMin() {
        return min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */