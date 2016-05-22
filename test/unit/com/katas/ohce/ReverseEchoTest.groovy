package com.katas.ohce

import spock.lang.Specification

class ReverseEchoTest extends Specification {

    Writer writerMock = Mock(Writer)

    private Echoer echoer

    void setup() {
        echoer = new ReverseEcho(writerMock)
    }

    def "should not print anything if text empty"() {
        when:
        echoer.echo(text)

        then:
        0 * writerMock.print(_)

        where:
        text | _
        null | _
        ""   | _
        "  " | _
    }

    def "should print reversed text"() {
        when:
        echoer.echo("Hola")

        then:
        1 * writerMock.print("aloH")
    }

    def "should like if its palindrom"() {
        when:
        echoer.echo("oto")

        then:
        1 * writerMock.print("oto")
        1 * writerMock.print("¡Bonita palabra!")
    }
}
