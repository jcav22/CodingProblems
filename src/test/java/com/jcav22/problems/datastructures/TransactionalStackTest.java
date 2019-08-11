package com.jcav22.problems.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TransactionalStackTest {

    @Test
    public void test1() {
        TransactionalStack sol = new TransactionalStack();
        sol.push(42);
        assertEquals(sol.top(), 42, "top should be 42");
    }

    @Test
    public void test2() {
        TransactionalStack stack1 = new TransactionalStack();
        stack1.push(5);
        stack1.push(2);              // stack: [5,2]
        assertEquals(stack1.top(), 2);
        stack1.pop();                      // stack: [5]
        assertEquals(stack1.top(), 5);

        TransactionalStack stack2 = new TransactionalStack();
        assertEquals(stack2.top(), 0);         // top of an empty stack is 0
        stack2.pop();                     // pop should do nothing
    }

    @Test
    public void test3() {
        TransactionalStack sol = new TransactionalStack();
        sol.push(4);
        sol.begin();                    // start transaction 1
        sol.push(7);                    // stack: [4,7]
        sol.begin();                    // start transaction 2
        sol.push(2);                    // stack: [4,7,2]
        assertTrue(sol.rollback());  // rollback transaction 2
        assertEquals(sol.top(), 7);          // stack: [4,7]
        sol.begin();                    // start transaction 3
        sol.push(10);                   // stack: [4,7,10]
        assertTrue(sol.commit());    // transaction 3 is committed
        assertEquals(sol.top(), 10);
        assertTrue(sol.rollback());  // rollback transaction 1
        assertEquals(sol.top(), 4);          // stack: [4]
        assertFalse(sol.commit());   // there is no open transaction
    }

}