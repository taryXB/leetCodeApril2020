/* Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

 

Constraints:

    Methods pop, top and getMin operations will always be called on non-empty stacks.

 */

class MinStack {
    /* initialize your data structure here. */
    static int top;
    static int min;
    static ArrayList<Integer> ar;

    public MinStack() {
        min = Integer.MAX_VALUE;
        top = -1;
        ar = new ArrayList<>();
    }

    public void push(int x) {
        top++;
        if(x<min){
            min = x;
        }
        ar.add(top,x);
    }

    public void pop() {
        if(top==-1)return;
        ar.remove(top);
        min = Integer.MAX_VALUE;
        for(int x: ar){
            if(x<min) min = x;
        }
        top--;
    }

    public int top() {
        return ar.get(top);
    }

    public int getMin() {
        return min;
    }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
