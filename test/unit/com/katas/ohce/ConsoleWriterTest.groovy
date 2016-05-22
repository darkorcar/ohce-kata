package com.katas.ohce

import spock.lang.Specification

class ConsoleWriterTest extends Specification {

    def "should print to output stream"() {
        given:
        OutputStream outputStream = new ByteArrayOutputStream()

        Writer writer = new ConsoleWriter(new PrintStream(outputStream))

        String text = "text to print"

        when:
        writer.print(text)

        then:
        outputStream.toString() == getExpectedOutput(text)
    }

    private String getExpectedOutput(String text) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        printStream.println(text)

        return new String(outputStream.toByteArray());
    }
}
