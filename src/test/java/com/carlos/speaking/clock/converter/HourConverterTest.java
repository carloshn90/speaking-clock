package com.carlos.speaking.clock.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HourConverterTest {

    StringToIntegerConverterImpl stringToIntegerConverterMock;
    HourConverter hourConverter;

    @BeforeEach
    void setUp() {
        this.stringToIntegerConverterMock = mock(StringToIntegerConverterImpl.class);
        this.hourConverter = new HourConverterImpl(this.stringToIntegerConverterMock);
    }

    @Test
    void convert_NullValue_EmptyOptional() {

        Optional<String> result = this.hourConverter.convert(null);

        assertFalse(result.isPresent());
    }

    @Test
    void convert_StringToIntConvertError_EmptyOptional() {

        String notValidHour = "not valid hour";

        when(this.stringToIntegerConverterMock.convert(notValidHour)).thenReturn(Optional.empty());

        Optional<String> result = this.hourConverter.convert(notValidHour);

        assertFalse(result.isPresent());
    }

    @Test
    void convert_ValueOutHourRange_EmptyOptional() {

        String twentyFiveStr = "25";
        int twentyFiveInt = 25;

        when(this.stringToIntegerConverterMock.convert(twentyFiveStr)).thenReturn(Optional.of(twentyFiveInt));

        Optional<String> result = this.hourConverter.convert(twentyFiveStr);

        assertFalse(result.isPresent());
    }

    @Test
    void convert_CorrectValue_OptionalOfSeven() {

        String sevenStr = "7";
        String sevenText = "seven";
        int sevenInt = 7;

        when(this.stringToIntegerConverterMock.convert(sevenStr)).thenReturn(Optional.of(sevenInt));

        Optional<String> result = this.hourConverter.convert(sevenStr);

        assertTrue(result.isPresent());
        assertEquals(sevenText, result.get());
    }
}
