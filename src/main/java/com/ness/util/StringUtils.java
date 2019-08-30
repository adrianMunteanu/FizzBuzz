package com.ness.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringUtils {
  public static <T>String formatMap(Map<String, T> map) {
    return map.entrySet()
      .stream()
      .map(entry -> entry.getKey() + ":" + entry.getValue())
      .collect(Collectors.joining(" "));
  }

  public static String formatList(List<String> fizzBuzzSequence) {
    return String.join(" ", fizzBuzzSequence);
  }
}
