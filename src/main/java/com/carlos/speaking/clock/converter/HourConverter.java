package com.carlos.speaking.clock.converter;

import java.util.Optional;

public interface HourConverter {

    Optional<String> convert(String hour);
}
