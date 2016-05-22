package com.katas.ohce

import spock.lang.Specification

class OhceTest extends Specification {

    private Greeter greeterMock = Mock(Greeter)

    private Echoer echoerMock = Mock(Echoer)

    private Ohce ohce

    void setup() {
        ohce = new Ohce(greeterMock, echoerMock)
    }

    def "should greet user"() {
        given:
        String name = "Darko"

        when:
        ohce.greet(name)

        then:
        1 * greeterMock.greet("Darko")
    }

    def "should echo reversed text"() {
        given:
        String text = "Hola"

        when:
        ohce.echo(text)

        then:
        1 * echoerMock.echo(text)
    }

    def "should greet goodbye and throw an exception on Stop word"() {
        given:
        String name = "Darko"
        String text = "Stop!"

        and:
        ohce.greet(name)

        when:
        ohce.echo(text)

        then:
        1 * greeterMock.goodbye(name)
        thrown(StopWordException)
    }
}
