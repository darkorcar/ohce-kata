package com.katas.ohce;

import org.springframework.util.StringUtils;

public class ReverseEcho implements Echoer {

    private static final String LIKE_MESSAGE = "¡Bonita palabra!";

    private final Writer writer;

    public ReverseEcho(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void echo(String text) {
        if (hasNoText(text)) {
            return;
        }

        String reversed = reverse(text);

        print(reversed);

        if (isPalindrom(text, reversed)) {
            print(LIKE_MESSAGE);
        }
    }

    private boolean hasNoText(String text) {
        return StringUtils.hasText(text) == false;
    }

    private String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    private void print(String text) {
        writer.print(text);
    }

    private boolean isPalindrom(String text, String reversed) {
        return text.equals(reversed);
    }
}
