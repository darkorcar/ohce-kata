package com.katas.ohce;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.PrintStream;

public class OhceApp {

    private Ohce ohce;

    private Reader reader;

    public OhceApp(Ohce ohce, Reader reader) {
        this.ohce = ohce;
        this.reader = reader;
    }

    public static void main(String[] args) throws InvalidArgumentException {

        String name = getNameArgument(args);

        OhceApp ohceApp = new OhceApp(
                ohce(System.out),
                new ConsoleReader(System.in)
        );

        ohceApp.greet(name);
        ohceApp.processInputs();
    }

    public void greet(String name) {
        ohce.greet(name);
    }

    public void processInputs() {
        while (reader.hasNext()) {
            String line = reader.nextLine();

            try {
                ohce.echo(line);
            } catch (StopWordException e) {
                return;
            }
        }
    }

    private static final Ohce ohce(PrintStream printStream) {
        TimeProvider timeProvider = new CurrentTimeProvider();

        Writer writer = new ConsoleWriter(printStream);

        Greeter greeter = new DayGreeter(timeProvider, writer);

        Echoer echoer = new ReverseEcho(writer);

        return new Ohce(greeter, echoer);
    }

    private static String getNameArgument(String[] args) throws InvalidArgumentException {
        if (args.length == 0) {
            throw new InvalidArgumentException(args);
        }

        return args[0];
    }

}
