package com.ness.service;

import com.ness.exception.IncorrectRangeException;
import com.ness.model.FizzBuzzResponse;
import com.ness.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@Service
public class FizzBuzzSerivce {

  Predicate<Integer> multipleOf(int n) {
    return i -> (i % n) == 0;
  }

  Predicate<Integer> containsThree() {
    return i -> i.toString().contains("3");
  }

  public String translate(int number) {
    String fizz = multipleOf(3).test(number) ? "fizz" : "";
    String buzz = multipleOf(5).test(number) ? "buzz" : "";
    return containsThree().test(number) ? "alfresco" : (fizz.isEmpty() && buzz.isEmpty()) ? String.valueOf(number) : fizz + buzz;
  }

  public FizzBuzzResponse produceSequence(int start, int end) {
    if (start >= end) {
      throw new IncorrectRangeException("Start index must be higher than end index");
    }

    List<String> fizzBuzzSequence = new ArrayList<>();
    Map<String, Integer> monitoringMap = initializeMap();

    IntStream.rangeClosed(start, end).mapToObj(this::translate).forEach(string -> {
      fizzBuzzSequence.add(string);
      if (monitoringMap.containsKey(string)) {
        monitoringMap.merge(string, 1, (oldValue, one) -> oldValue + one);
      }
      else {
        monitoringMap.merge("integer", 1, (oldValue, one) -> oldValue + one);
      }
    });

    String sequenceResult = StringUtils.formatList(fizzBuzzSequence);
    String monitoringResult = StringUtils.formatMap(monitoringMap);
    return new FizzBuzzResponse(sequenceResult, monitoringResult);
  }

  private Map<String, Integer> initializeMap() {
    return new HashMap<String, Integer>() {{
      put("alfresco", 0);
      put("fizz", 0);
      put("fizzbuzz", 0);
      put("buzz", 0);
      put("integer", 0);
    }};
  }
}
