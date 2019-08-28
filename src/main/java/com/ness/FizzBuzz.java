package com.ness;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.function.Predicate;

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
    List<String> sequence = new ArrayList<>();
    IntStream.rangeClosed(start, end)
      .mapToObj(this::translate)
      .forEach(sequence::add);

    return String.join(" ", sequence);
  }
}
