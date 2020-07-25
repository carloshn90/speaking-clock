package com.carlos.speaking.clock.converter;

import java.util.Optional;

import static com.carlos.speaking.clock.converter.Constant.INTEGER_NAME_MAP;

public class HourConverterImpl implements HourConverter {

    private final StringToIntegerConverter stringToIntegerConverter;

    public HourConverterImpl(StringToIntegerConverterImpl stringToIntegerConverter) {
        this.stringToIntegerConverter = stringToIntegerConverter;
    }

    @Override
    public Optional<String> convert(String hour) {

        return this.stringToIntegerConverter.convert(hour)
                .flatMap(this::getHourFromMap);
    }

    private Optional<String> getHourFromMap(int hour) {

        if (hour > 24) return Optional.empty();

        return INTEGER_NAME_MAP.containsKey(hour)
                ? Optional.of(INTEGER_NAME_MAP.get(hour))
                : Optional.empty();
    }
}
