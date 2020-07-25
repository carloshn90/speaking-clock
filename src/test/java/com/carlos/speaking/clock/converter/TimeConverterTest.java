package com.carlos.speaking.clock.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TimeConverterTest {

    HourConverter hourConverterMock;
    MinuteConverter minuteConverterMock;
    TimeConverter timeConverter;

    @BeforeEach
    void setUp() {
        this.hourConverterMock = mock(HourConverter.class);
        this.minuteConverterMock = mock(MinuteConverter.class);
        this.timeConverter = new TimeConverterImpl(this.hourConverterMock, this.minuteConverterMock);
    }

    @Test
    void convert_NullValue_IllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> this.timeConverter.convert(null));
    }

    @Test
    void convert_Midday_MiddayText() {

        String middayTime = "12:00";
        String resultText = "It's Midday";

        String result = this.timeConverter.convert(middayTime);

        assertEquals(resultText, result);
    }

    @Test
    void convert_Midnight_MidnightText() {

        String midnightTime = "24:00";
        String expectedResult = "It's Midnight";

        String result = this.timeConverter.convert(midnightTime);

        assertEquals(expectedResult, result);
    }

    @Test
    void convert_TimeFormatNotCorrect_IllegalArgumentException() {

        String errorTimeFormat = "2400";

        assertThrows(IllegalArgumentException.class, () -> this.timeConverter.convert(errorTimeFormat));
    }

    @Test
    void convert_FormatHourNotCorrect_IllegalArgumentException() {

        String hourError = "34";
        String minute = "00";
        String errorHourFormat = String.format("%s:%s", hourError, minute);

        when(this.hourConverterMock.convert(hourError)).thenReturn(Optional.empty());
        when(this.minuteConverterMock.convert(minute)).thenReturn(Optional.of("zero"));

        assertThrows(IllegalArgumentException.class, () -> this.timeConverter.convert(errorHourFormat));

        verify(this.hourConverterMock, times(1)).convert(hourError);
        verify(this.minuteConverterMock, times(1)).convert(minute);
    }

    @Test
    void convert_FormatMinuteNotCorrect_IllegalArgumentException() {

        String hour = "10";
        String minuteError = "77";
        String errorMinuteFormat = String.format("%s:%s", hour, minuteError);

        when(this.hourConverterMock.convert(hour)).thenReturn(Optional.of("ten"));
        when(this.minuteConverterMock.convert(minuteError)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> this.timeConverter.convert(errorMinuteFormat));

        verify(this.hourConverterMock, times(1)).convert(hour);
        verify(this.minuteConverterMock, times(1)).convert(minuteError);
    }

    @Test
    void convert_CorrectTime_TimeInText() {

        String hour = "08";
        String minute = "34";
        String correctTimeFormat = String.format("%s:%s", hour, minute);
        String expectedResult = "It's eight thirty four";

        when(this.hourConverterMock.convert(hour)).thenReturn(Optional.of("eight"));
        when(this.minuteConverterMock.convert(minute)).thenReturn(Optional.of("thirty four"));

        String result = this.timeConverter.convert(correctTimeFormat);

        assertEquals(expectedResult, result);

        verify(this.hourConverterMock, times(1)).convert(hour);
        verify(this.minuteConverterMock, times(1)).convert(minute);
    }

}
