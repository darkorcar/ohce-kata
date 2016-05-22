package com.katas.ohce;

import java.time.LocalTime;

public class CurrentTimeProvider implements TimeProvider {

    @Override
    public int hour() {
        return LocalTime.now().getHour();
    }

}
