package com.carlos.speaking.clock.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerConverterTest {

    Converter<String, Optional<Integer>> stringToIntegerConverter;

    @BeforeEach
    void setUp() {
        this.stringToIntegerConverter = new StringToIntegerConverter();
    }

    @Test
    void convert_NullValue_EmptyOptional() {
        Optional<Integer> result = this.stringToIntegerConverter.convert(null);

        assertFalse(result.isPresent());
    }

    @Test
    void convert_NotNumberValue_EmptyOptional() {
        Optional<Integer> result = this.stringToIntegerConverter.convert("test not number");

        assertFalse(result.isPresent());
    }

    @Test
    void convert_NumberValueWithZeroAtStart_OptionalOfEight() {
        Optional<Integer> result = this.stringToIntegerConverter.convert("08");

        assertTrue(result.isPresent());
        assertEquals(8, result.get());
    }

}
