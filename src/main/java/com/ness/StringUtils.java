package com.ness;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringUtils {
  public static String formatMap(Map<String, Integer> map) {
    return map.entrySet()
      .stream()
      .map(entry -> entry.getKey() + ":" + entry.getValue())
      .collect(Collectors.joining(" "));
  }

  public static String formatFizzBuzzRestult(List<String> fizzBuzzSequence, String monitoringResult) {
    return String.join(" ", fizzBuzzSequence)
      + System.lineSeparator()
      + monitoringResult;
  }
}
