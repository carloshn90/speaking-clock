package com.carlos.speaking.clock.converter;

import java.util.Optional;

public interface StringToIntegerConverter {

    Optional<Integer> convert(String value);
}
