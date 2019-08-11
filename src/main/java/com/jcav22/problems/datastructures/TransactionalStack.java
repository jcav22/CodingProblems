package com.jcav22.problems.datastructures;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionalStack {
    private static AtomicInteger transactionId = new AtomicInteger(0);

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
            transactions.peek().push(value);
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
            transactions.peek().pop();
        }
    }

    public void begin() {
        transactions.push(new Transaction(transactionId.addAndGet(1), content));
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
        Stack<Integer> committedContent = (Stack<Integer>) transactions.pop().transactionContent.clone();

        if (transactions.isEmpty()) {
            this.content = committedContent;
        } else {
            transactions.peek().transactionContent = committedContent;
        }

        return true;
    }

    static class Transaction {
        private int id;
        private Stack<Integer> transactionContent;

        public Transaction(int id, Stack content) {
            this.id = id;
            this.transactionContent = (Stack<Integer>) content.clone();
        }

        public void pop() {
            this.transactionContent.pop();
        }

        public void push(int element) {
            this.transactionContent.push(element);
        }

        public int peek() {
            if (this.transactionContent.isEmpty()) {
                return 0;
            }
            return this.transactionContent.peek();
        }

        public int getId() {
            return this.id;
        }
    }
}
