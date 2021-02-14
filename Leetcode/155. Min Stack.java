/* Problem Link: https://leetcode.com/problems/min-stack/ */

import java.util.*;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min_values;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min_values = new Stack<Integer>();
    }

    public void push(int x) {
        if (min_values.isEmpty() || x <= min_values.peek()) {
            min_values.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(min_values.peek())) {
            min_values.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_values.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
