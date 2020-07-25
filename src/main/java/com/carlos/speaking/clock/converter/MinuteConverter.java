package com.carlos.speaking.clock.converter;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.carlos.speaking.clock.Constant.INTEGER_NAME_MAP;

@RequiredArgsConstructor
public class MinuteConverter implements Converter<String, Optional<String>> {

    private final Converter<String, Optional<Integer>> stringToIntegerConverter;

    @Override
    public Optional<String> convert(String minute) {

        return this.stringToIntegerConverter.convert(minute)
                .flatMap(this::getMinuteFromMap);
    }

    private Optional<String> getMinuteFromMap(int minute) {

        return INTEGER_NAME_MAP.containsKey(minute)
                ? Optional.of(INTEGER_NAME_MAP.get(minute))
                : Optional.empty();
    }
}
