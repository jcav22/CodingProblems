package com.jcav22.problems.datastructures;

import java.util.Stack;

public class TransactionalStack {
    private int transactionId = 0;

    private Stack<Integer> content;
    private Stack<Transaction> transactions;

    public TransactionalStack() {
        content = new Stack();
        transactions = new Stack();
    }

    public void push(int value) {
        if (transactions.isEmpty()) {
            content.push(value);
        } else {
            transactions.peek().content.push(value);
        }
    }

    public int top() {
        if (transactions.isEmpty()) {
            if (!content.isEmpty()) {
                return content.peek();
            } else {
                return 0;
            }
        }
        return transactions.peek().peek();
    }

    public void pop() {
        if (transactions.isEmpty()) {
            if (!content.isEmpty()) {
                content.pop();
            }
        } else {
            transactions.peek().content.pop();
        }
    }

    public void begin() {
        transactions.push(new Transaction(++transactionId, content));
    }

    public boolean rollback() {
        if (transactions.isEmpty()) {
            return false;
        }
        transactions.pop();
        return true;
    }

    public boolean commit() {
        if (transactions.isEmpty()) {
            return false;
        }
        content = transactions.pop().content;
        return true;
    }

    static class Transaction {
        public int id;
        private Stack<Integer> content;

        public Transaction(int id, Stack content) {
            this.id = id;
            this.content = (Stack<Integer>) content.clone();
        }

        public void push(int element) {
            this.content.push(element);
        }

        public int peek() {
            if (content.isEmpty()) {
                return 0;
            }
            return content.peek();
        }
    }

    public static void test() {
        TransactionalStack sol = new TransactionalStack();
        sol.push(42);
        assert sol.top() == 42 : "top() should be 42";
    }

    public static void example1() {
        TransactionalStack sol = new TransactionalStack();
        sol.push(5);
        sol.push(2);              // stack: [5,2]
        assert sol.top() == 2;
        sol.pop();                      // stack: [5]
        assert sol.top() == 5;

        TransactionalStack sol2 = new TransactionalStack();
        assert sol2.top() == 0;         // top of an empty stack is 0
        sol2.pop();                     // pop should do nothing
    }

    public static void example2() {
        TransactionalStack sol = new TransactionalStack();
        sol.push(4);
        sol.begin();                    // start transaction 1
        sol.push(7);                    // stack: [4,7]
        sol.begin();                    // start transaction 2
        sol.push(2);                    // stack: [4,7,2]
        assert sol.rollback() == true;  // rollback transaction 2
        assert sol.top() == 7;          // stack: [4,7]
        sol.begin();                    // start transaction 3
        sol.push(10);                   // stack: [4,7,10]
        assert sol.commit() == true;    // transaction 3 is committed
        assert sol.top() == 10;
        assert sol.rollback() == true;  // rollback transaction 1
        assert sol.top() == 4;          // stack: [4]
        assert sol.commit() == false;   // there is no open transaction
    }

    public static void main(String[] args) {
        test();
        example1();
        example2();
    }
}
