package com.katas.ohce;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader implements Reader {

    private final Scanner scanner;

    public ConsoleReader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
