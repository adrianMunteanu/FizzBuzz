package com.ness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

  Predicate<Integer> multipleOf(int n) {
    return i -> (i % n) == 0;
  }

  Predicate<Integer> containsThree() {
    return i -> i.toString().contains("3");
  }

  public String translate(int number) {
    String fizz = multipleOf(3).test(number) ? "fizz" : "";
    String buzz = multipleOf(5).test(number) ? "buzz" : "";
    return containsThree().test(number) ?
      "alfresco" :
      (fizz.isEmpty() && buzz.isEmpty()) ? String.valueOf(number) : fizz + buzz;
  }

  public String produceSequence(int start, int end) {
    if (start >= end) {
      return "Invalid Range";
    }

    List<String> fizzBuzzSequence = new ArrayList<>();
    Map<String, Integer> monitoringMap = initializeMap();

    IntStream.rangeClosed(start, end)
      .mapToObj(this::translate)
      .forEach(string -> {
        fizzBuzzSequence.add(string);
        if(monitoringMap.containsKey(string)) {
          monitoringMap.merge(string, 1, (oldValue, one) -> oldValue + one);
        } else {
          monitoringMap.merge("integer", 1, (oldValue, one) -> oldValue + one);
        }
      });

    String monitoringResult = StringUtils.formatMap(monitoringMap);
    return StringUtils.formatFizzBuzzRestult(fizzBuzzSequence,monitoringResult );
  }

  private Map<String, Integer> initializeMap() {
    return new HashMap<String, Integer>(){{
      put("alfresco", 0);
      put("fizz", 0);
      put("fizzbuzz", 0);
      put("buzz", 0);
      put("integer", 0);
    }};
  }
}
