package com.carlos.speaking.clock.converter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Constant {

    private Constant() {
        throw new IllegalAccessError("Constant class");
    }

    public static final List<Integer> LIST_OF_INTEGER_FROM_ONE_TO_SIXTY = Arrays.stream(IntStream.range(0, 60).toArray())
            .boxed()
            .collect(Collectors.toList());

    public static final List<String> LIST_OF_STRING_FROM_ONE_TO_SIXTY = Stream
            .of(
                    "Zero",
                    "one",
                    "two",
                    "three",
                    "four",
                    "five",
                    "six",
                    "seven",
                    "eight",
                    "nine",
                    "ten",
                    "eleven",
                    "twelve",
                    "thirteen",
                    "fourteen",
                    "fifteen",
                    "sixteen",
                    "seventeen",
                    "eighteen",
                    "nineteen",
                    "twenty",
                    "twenty one",
                    "twenty two",
                    "twenty three",
                    "twenty four",
                    "twenty five",
                    "twenty six",
                    "twenty seven",
                    "twenty eight",
                    "twenty nine",
                    "thirty",
                    "thirty one",
                    "thirty two",
                    "thirty three",
                    "thirty four",
                    "thirty five",
                    "thirty six",
                    "thirty seven",
                    "thirty eight",
                    "thirty nine",
                    "forty",
                    "forty one",
                    "forty two",
                    "forty three",
                    "forty four",
                    "forty five",
                    "forty six",
                    "forty seven",
                    "forty eight",
                    "forty nine",
                    "fifty",
                    "fifty one",
                    "fifty two",
                    "fifty three",
                    "fifty four",
                    "fifty five",
                    "fifty six",
                    "fifty seven",
                    "fifty eight",
                    "fifty nine",
                    "sixty"
            ).collect(Collectors.toList());

    public static final Map<Integer, String> INTEGER_NAME_MAP = LIST_OF_INTEGER_FROM_ONE_TO_SIXTY.stream()
            .collect(Collectors.toMap(valueInt -> valueInt, LIST_OF_STRING_FROM_ONE_TO_SIXTY::get));
}
