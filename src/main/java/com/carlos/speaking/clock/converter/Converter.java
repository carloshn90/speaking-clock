package com.carlos.speaking.clock.converter;

public interface Converter<S,T> {

    T convert(S source);
}