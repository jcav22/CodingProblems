package com.jcav22.problems.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyStackTest {

    @Test
    public void testMyStack() {
        MyStack<Integer> myStack = new MyStack<>();
        assertTrue(myStack.isEmpty());
        myStack.push(3);
        assertFalse(myStack.isEmpty());
        assertEquals(3, myStack.peek());
        myStack.push(5);
        myStack.push(7);
        assertEquals(7, myStack.peek());
        assertEquals(7, myStack.pop());
        assertEquals(5, myStack.peek());
        myStack.push(9);
        assertEquals(9, myStack.peek());
        assertEquals(3, myStack.size());
        assertEquals(-1, myStack.search(1));
        assertEquals(2, myStack.search(3));
        myStack.pop();
        assertEquals(5, myStack.pop());
        myStack.pop();
        assertTrue(myStack.isEmpty());
        assertEquals(0, myStack.size());
    }
}