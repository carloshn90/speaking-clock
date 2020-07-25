package com.carlos.speaking.clock.converter;

import java.util.Optional;

public class StringToIntegerConverterImpl implements StringToIntegerConverter {

    @Override
    public Optional<Integer> convert(String value) {

        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }

    }
}
