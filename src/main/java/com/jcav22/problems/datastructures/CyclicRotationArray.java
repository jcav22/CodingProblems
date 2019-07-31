package com.jcav22.problems.datastructures;

public class CyclicRotationArray {

    public static int[] solution(int[] A, int K) {
        if (K == A.length || A.length < 2)
            return A;

        int length = A.length;
        int realK = K % length;
        int[] result = new int[length];

        for (int i = 0; i < realK; i++) {
            result[realK - 1 - i] = A[length - 1 - i];
        }

        for (int i = 0; i < length - realK; i++) {
            result[realK + i] = A[i];
        }

        return result;
    }
}
