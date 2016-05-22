package com.katas.ohce

import spock.lang.Specification

class DayGreeterTest extends Specification {

    private Writer writerMock = Mock(Writer)

    private TimeProvider timeProviderMock = Mock(TimeProvider)

    private Greeter greeter

    void setup() {
        greeter = new DayGreeter(timeProviderMock, writerMock)
    }

    def "should print name with buenas noches when hour between 20 - 6"() {
        given:
        timeProviderMock.hour() >> 21

        String name = "Darko"

        when:
        greeter.greet(name)

        then:
        1 * writerMock.print("¡Buenas noches $name!")
    }

    def "should print name with buenos dias when hour between 6 - 12"() {
        given:
        timeProviderMock.hour() >> 7

        String name = "Darko"

        when:
        greeter.greet(name)

        then:
        1 * writerMock.print("¡Buenos dias $name!")
    }

    def "should print name with buenas tardes when hour between 12 - 20"() {
        given:
        timeProviderMock.hour() >> 13

        String name = "Darko"

        when:
        greeter.greet(name)

        then:
        1 * writerMock.print("¡Buenas tardes $name!")
    }

    def "shoulr print adios on goodbye"() {
        given:
        String name = "Darko"

        when:
        greeter.goodbye(name)

        then:
        1 * writerMock.print("Adios $name")
    }
}
