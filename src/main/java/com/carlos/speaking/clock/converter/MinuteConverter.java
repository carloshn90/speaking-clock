package com.carlos.speaking.clock.converter;

import java.util.Optional;

public interface MinuteConverter {

    Optional<String> convert(String minute);
}
