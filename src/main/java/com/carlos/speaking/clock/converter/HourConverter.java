package com.carlos.speaking.clock.converter;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.carlos.speaking.clock.Constant.INTEGER_NAME_MAP;

@RequiredArgsConstructor
public class HourConverter implements Converter<String, Optional<String>> {

    private final Converter<String, Optional<Integer>> stringToIntegerConverter;

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
