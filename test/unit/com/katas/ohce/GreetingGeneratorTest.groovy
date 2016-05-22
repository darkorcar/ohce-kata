package com.katas.ohce

import spock.lang.Specification

class GreetingGeneratorTest extends Specification {

    GreetingGenerator greetingGenerator = new GreetingGenerator()

    def "should greet name with buenas noches when hour between 20 - 6"() {
        given:
        String name = "Darko"

        when:
        String greeting = greetingGenerator.periodOfDayGreeting(hour, name)

        then:
        greeting == "¡Buenas noches $name!"

        where:
        hour << [20, 21, 22, 23, 24, 0, 1, 2, 3, 4, 5]
    }

    def "should greet name with buenos dias when hour between 6 - 12"() {
        given:
        String name = "Darko"

        when:
        String greeting = greetingGenerator.periodOfDayGreeting(hour, name)

        then:
        greeting == "¡Buenos dias $name!"

        where:
        hour << [6, 7, 8, 9, 10, 11]
    }

    def "should greet name with buenas tardes when hour between 12 - 20"() {
        given:
        String name = "Darko"

        when:
        String greeting = greetingGenerator.periodOfDayGreeting(hour, name)

        then:
        greeting == "¡Buenas tardes $name!"

        where:
        hour << [12, 13, 14, 15, 16, 17, 18, 19]
    }
}
