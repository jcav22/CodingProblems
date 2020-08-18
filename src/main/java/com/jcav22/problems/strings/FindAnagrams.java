package com.jcav22.problems.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int i = 0;

        while (i < s.length() && s.substring(i).length() >= p.length()) {
            String substring = s.substring(i, i + p.length());
            if (isAnagram(substring, p)) {
                result.add(i);
            }
            i++;
        }
        return result;
    }

    static boolean isAnagram(String s, String p) {
        if (s.length() == 1) {
            return p.equals(s);
        }
        StringBuilder sb = new StringBuilder(s);
        boolean match = true;
        int i = 0;
        while (i < p.length() && match) {
            int index = sb.indexOf(String.valueOf(p.charAt(i)));
            if (index == -1) {
                match = false;
            } else {
                sb.deleteCharAt(index);
            }
            i++;
        }
        return match;
    }
}
