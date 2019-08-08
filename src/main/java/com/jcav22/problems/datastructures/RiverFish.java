package com.jcav22.problems.datastructures;

import java.util.Stack;

public class RiverFish {

    public static int solution(int[] A, int[] B) {
        Stack<FishTuple> stack = new Stack();

        stack.push(new FishTuple(A[0], B[0]));

        for (int i = 1; i < B.length; i++) {
            FishTuple peek = stack.peek();
            if (peek.dir == 1 && B[i] == 0) {
                if (peek.weight < A[i]) {
                    while (peek.weight < A[i] && !stack.empty()) {
                        stack.pop();
                        if (stack.empty()) {
                            stack.push(new FishTuple(A[i], B[i]));
                            break;
                        } else {
                            peek = stack.peek();
                        }
                    }
                    if (peek.dir == B[i]) {
                        stack.push(new FishTuple(A[i], B[i]));
                    }
                }
            } else {
                stack.push(new FishTuple(A[i], B[i]));
            }
        }
        return stack.size();
    }

    static class FishTuple {
        public int weight;
        public int dir;

        public FishTuple(int weight, int dir) {
            this.weight = weight;
            this.dir = dir;
        }
    }
}
