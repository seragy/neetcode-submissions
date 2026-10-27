class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        // first value is the min, otherwise keep the smaller one
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


// class MinStack {
//     private Stack<Integer> mainStack; // Stack to hold all values
//     private Stack<Integer> minStack;  // Stack to track the minimum values

//     public MinStack() {
//         mainStack = new Stack<>();
//         minStack = new Stack<>();
//     }

//     public void push(int val) {
//         mainStack.push(val);
//         // If the minStack is empty or the new value is less than or equal to the current minimum, push it onto the minStack
//         if (minStack.isEmpty() || val <= minStack.peek()) {
//             minStack.push(val);
//         }
//     }

//     public void pop() {
//         // If the value being popped is the current minimum, pop it from minStack as well
//         if (mainStack.peek().equals(minStack.peek())) {
//             minStack.pop();
//         }
//         mainStack.pop();
//     }

//     public int top() {
//         return mainStack.peek(); // Return the top value of mainStack
//     }

//     public int getMin() {
//         return minStack.peek(); // The top of minStack is the current minimum
//     }
// }