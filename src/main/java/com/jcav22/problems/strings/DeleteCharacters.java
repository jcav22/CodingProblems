package com.jcav22.problems.strings;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class DeleteCharacters {

    static String processString(String sequence, String toDelete) {
        final Map<String, String> charsToDelete = new HashMap<>();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < toDelete.length(); i++) {
            charsToDelete.put(String.valueOf(toDelete.charAt(i)), "");
        }

        for (int j = 0; j < sequence.length(); j++) {
            String singleChar = String.valueOf(sequence.charAt(j));
            if (isNull(charsToDelete.get(singleChar))) {
                sb.append(singleChar);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String result = processString(
                "Battle of the Vowels: Hawaii vs. Grozny", "aeiou");
        assert(result.equals("Bttl f th Vwls: Hw vs. Grzny"));
    }
}
