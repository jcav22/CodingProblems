package com.jcav22.problems.algorithms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryGap {

    private static final String PATTERN = "10+1";

    public static int solution(int N) {
        String binaryString = Integer.toBinaryString(N);

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(binaryString);

        int max = matcher.find() ? matcher.end()-matcher.start()-2 : 0;
        int lastPosition = max != 0 ? matcher.end()-1 : 0;

        while (matcher.find(lastPosition)) {
            int length = matcher.end()-matcher.start()-2;
            if (length > max)
                max = length;
            lastPosition = matcher.end()-1;
        }

        return max;
    }
}
