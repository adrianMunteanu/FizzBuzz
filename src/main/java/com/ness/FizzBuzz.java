package com.ness;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

  java.util.function.Predicate<Integer> multipleOf(int n) {
    return i -> (i % n) == 0;
  }

  public String translate(int number) {
    String fizz = multipleOf(3).test(number) ? "Fizz" : "";
    String buzz = multipleOf(5).test(number) ? "Buzz" : "";
    return (fizz.isEmpty() && buzz.isEmpty()) ? String.valueOf(number) : fizz + buzz;
  }

  public String produceSequence(int start, int end) {
    List<String> sequence = new ArrayList<>();
    IntStream.rangeClosed(start, end)
      .mapToObj(this::translate)
      .forEach(sequence::add);

    return String.join(" ", sequence);
  }
}
