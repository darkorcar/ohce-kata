package com.katas.ohce;

public class DayGreeter implements Greeter {

    private static final String ADIOS_MESSAGE = "Adios";

    private final TimeProvider timeProvider;

    private final Writer writer;

    private final GreetingGenerator greetingGenerator;

    public DayGreeter(TimeProvider timeProvider, Writer writer) {
        this.timeProvider = timeProvider;
        this.writer = writer;
        this.greetingGenerator = new GreetingGenerator();
    }

    @Override
    public void greet(String name) {
        int hour = getHour();

        String greeting = getGreeting(hour, name);

        print(greeting);
    }

    @Override
    public void goodbye(String name) {
        print(ADIOS_MESSAGE + " " + name);
    }

    private int getHour() {
        return timeProvider.hour();
    }

    private String getGreeting(int hour, String name) {
        return greetingGenerator.periodOfDayGreeting(hour, name);
    }

    private void print(String greeting) {
        writer.print(greeting);
    }
}
