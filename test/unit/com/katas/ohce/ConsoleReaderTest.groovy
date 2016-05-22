package com.katas.ohce

import spock.lang.Specification

class ConsoleReaderTest extends Specification {

    def "should read from input stream"() {
        given:
        String input = "Pedro"
        InputStream inputStream = new ByteArrayInputStream(input.bytes)

        ConsoleReader consoleReader = new ConsoleReader(inputStream)

        when:
        consoleReader.hasNext()

        then:
        consoleReader.nextLine() == input
    }

}
