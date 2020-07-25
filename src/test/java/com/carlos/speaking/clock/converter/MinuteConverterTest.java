package com.carlos.speaking.clock.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MinuteConverterTest {

    StringToIntegerConverterImpl stringToIntegerConverterMock;
    MinuteConverter minuteConverter;

    @BeforeEach
    void setUp() {
        this.stringToIntegerConverterMock = mock(StringToIntegerConverterImpl.class);
        this.minuteConverter = new MinuteConverterImpl(this.stringToIntegerConverterMock);
    }

    @Test
    void convert_NullValue_EmptyOptional() {

        Optional<String> result = this.minuteConverter.convert(null);

        assertFalse(result.isPresent());
    }

    @Test
    void convert_NotNumberValue_EmptyOptional() {

        String notValidMinute = "not valid Minute";

        when(this.stringToIntegerConverterMock.convert(notValidMinute)).thenReturn(Optional.empty());

        Optional<String> result = this.minuteConverter.convert(notValidMinute);

        assertFalse(result.isPresent());
    }

    @Test
    void convert_ValueOutMinuteRangeUp_EmptyOptional() {

        String sixtyOneStr = "61";
        int sixtyOneInt = 61;

        when(this.stringToIntegerConverterMock.convert(sixtyOneStr)).thenReturn(Optional.of(sixtyOneInt));

        Optional<String> result = this.minuteConverter.convert(sixtyOneStr);

        assertFalse(result.isPresent());
    }

    @Test
    void convert_ValueOutMinuteRangeDown_EmptyOptional() {

        String minusOneStr = "-1";
        int minusOneInt = -1;

        when(this.stringToIntegerConverterMock.convert(minusOneStr)).thenReturn(Optional.of(minusOneInt));

        Optional<String> result = this.minuteConverter.convert(minusOneStr);

        assertFalse(result.isPresent());
    }

    @Test
    void convert_CorrectValue_OptionalOfSeven() {

        String thirtyText = "thirty";
        String thirtyStr = "30";
        int thirtyInt = 30;

        when(this.stringToIntegerConverterMock.convert(thirtyStr)).thenReturn(Optional.of(thirtyInt));

        Optional<String> result = this.minuteConverter.convert(thirtyStr);

        assertTrue(result.isPresent());
        assertEquals(thirtyText, result.get());
    }

}
