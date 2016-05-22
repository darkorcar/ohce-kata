package com.katas.ohce;

public class GreetingGenerator {

    String periodOfDayGreeting(int hour, String name) {
        String greeting = "¡";

        if (isNoches(hour)) {
            greeting += "Buenas noches ";
        } else if (isDias(hour)) {
            greeting += "Buenos dias ";
        } else if (isTardes(hour)) {
            greeting += "Buenas tardes ";
        }

        greeting += name + "!";

        return greeting;
    }

    private boolean isTardes(int hour) {
        return hour >= 12 && hour <= 19;
    }

    private boolean isDias(int hour) {
        return hour >= 6 && hour <= 11;
    }

    private boolean isNoches(int hour) {
        return (hour >= 0 && hour <= 5) || (hour >= 20 && hour <= 24);
    }
}