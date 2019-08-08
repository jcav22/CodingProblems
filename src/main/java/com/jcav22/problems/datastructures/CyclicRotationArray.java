package com.jcav22.problems.datastructures;

public class CyclicRotationArray {

    public static int[] solution(int[] A, int K) {
        int length = A.length;

        if (K == length || length < 2)
            return A;

        int numRotations = K % length;
        int[] result = new int[length];

        for (int i = 0; i < numRotations; i++) {
            result[numRotations - 1 - i] = A[length - 1 - i];
        }

        for (int i = 0; i < length - numRotations; i++) {
            result[numRotations + i] = A[i];
        }

        return result;
    }
}
