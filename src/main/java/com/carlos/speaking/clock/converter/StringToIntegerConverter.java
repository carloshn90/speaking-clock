package com.carlos.speaking.clock.converter;

import java.util.Optional;

public class StringToIntegerConverter implements Converter<String, Optional<Integer>> {

    @Override
    public Optional<Integer> convert(String value) {

        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }

    }
}
