package com.katas.ohce;

public class Ohce {

    private static final String STOP_WORD = "Stop!";

    private final Greeter greeter;

    private final Echoer echoer;

    private String name;

    public Ohce(Greeter greeter, Echoer echoer) {
        this.greeter = greeter;
        this.echoer = echoer;
    }

    public void greet(String name) {

        this.name = name;

        greeter.greet(name);
    }

    public void echo(String text) throws StopWordException {
        goodbyeIfStopWord(text);

        echoer.echo(text);
    }

    private void goodbyeIfStopWord(String text) throws StopWordException {
        if (text.equals(STOP_WORD)) {
            greeter.goodbye(name);
            throw new StopWordException();
        }
    }
}
