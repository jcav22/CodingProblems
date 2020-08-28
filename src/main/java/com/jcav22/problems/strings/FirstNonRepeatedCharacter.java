package com.jcav22.problems.strings;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class FirstNonRepeatedCharacter {

    static String detect(String sequence) {
        final Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < sequence.length(); i++) {
            final String singleChar = String.valueOf(sequence.charAt(i));
            if (isNull(map.get(singleChar))) {
                map.put(singleChar, 1);
            } else {
                map.put(singleChar, map.get(singleChar) + 1);
            }
        }

        String firstNonRepeated = "";
        boolean found = false;
        int j = 0;
        while (j < sequence.length() && !found) {
            final String s = String.valueOf(sequence.charAt(j));
            if (map.get(s) == 1) {
                firstNonRepeated = s;
                found = true;
            }
            j++;
        }

        return firstNonRepeated;
    }
}
