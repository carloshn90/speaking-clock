package com.carlos.speaking.clock.converter;

import java.util.Optional;

import static com.carlos.speaking.clock.converter.Constant.INTEGER_NAME_MAP;

public class MinuteConverterImpl implements MinuteConverter {

    private final StringToIntegerConverter stringToIntegerConverter;

    public MinuteConverterImpl(StringToIntegerConverterImpl stringToIntegerConverter) {
        this.stringToIntegerConverter = stringToIntegerConverter;
    }

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
