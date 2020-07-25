package com.carlos.speaking.clock.converter;

import java.util.Optional;

public class TimeConverterImpl implements TimeConverter {

    private final HourConverter hourConverter;
    private final MinuteConverter minuteConverter;

    public TimeConverterImpl(HourConverter hourConverter, MinuteConverter minuteConverter) {
        this.hourConverter = hourConverter;
        this.minuteConverter = minuteConverter;
    }

    @Override
    public String convert(String time) {

        if (time == null) throw new IllegalArgumentException("Time is null");

        if (this.isMidday(time)) return "It's Midday";

        if (this.isMidnight(time)) return "It's Midnight";

        String[] hourMinute = time.split(":");

        if (hourMinute.length != 2)
            throw new IllegalArgumentException("Time format not support. The supported format is HH:MM");

        Optional<String> hourTextOptional = this.hourConverter.convert(hourMinute[0]);
        Optional<String> minuteTextOptional = this.minuteConverter.convert(hourMinute[1]);

        if (!hourTextOptional.isPresent() || !minuteTextOptional.isPresent())
            throw new IllegalArgumentException("Error in the conversion process, check hours minutes values");


        return String.format("It's %s %s", hourTextOptional.get(), minuteTextOptional.get());
    }

    private boolean isMidday(String time) {
        return "12:00".equals(time);
    }

    private boolean isMidnight(String time) {
        return "24:00".equals(time);
    }
}
