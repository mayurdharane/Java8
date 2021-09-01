package com.mayur.regex;

import java.util.regex.Pattern;

public class IPMatcher {

    public static void main(String[] args) {

        String text    =
                "This is the text to be searched " +
                        "for occurrences of the pattern.";

        String pattern = ".*is.*";

        boolean matches = Pattern.matches(pattern, text);

        System.out.println("matches = " + matches);
    }
}
