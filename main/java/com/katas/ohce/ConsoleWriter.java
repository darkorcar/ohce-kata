package com.katas.ohce;

import java.io.PrintStream;

public class ConsoleWriter implements Writer {

    private final PrintStream printStream;

    public ConsoleWriter(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void print(String text) {
        printStream.println(text);
    }
}
