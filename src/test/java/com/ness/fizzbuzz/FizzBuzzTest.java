package com.ness.fizzbuzz;

import com.ness.FizzBuzz;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

  private FizzBuzz fizzBuzz = new FizzBuzz();
  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";
  private static final String FIZZ_BUZZ = "FizzBuzz";

  @Test
  public void translateWithNonMultipleNumbersShouldReturnThoseNumbers() {
    assertEquals("1", fizzBuzz.translate(1));
    assertEquals("2", fizzBuzz.translate(2));
  }

  @Test
  public void translateWithMultipleOfThreeShouldReturnFizz() {
    assertEquals(FIZZ, fizzBuzz.translate(3));
    assertEquals(FIZZ, fizzBuzz.translate(6));
    assertEquals(FIZZ, fizzBuzz.translate(9));
  }

  @Test
  public void translateWithMultipleOfFiveShouldReturnBuzz() {
    assertEquals(BUZZ, fizzBuzz.translate(5));
    assertEquals(BUZZ, fizzBuzz.translate(10));
    assertEquals(BUZZ, fizzBuzz.translate(20));
  }

  @Test
  public void translateWithMultipleOfFifteenShouldReturnBuzz() {
    assertEquals(FIZZ_BUZZ, fizzBuzz.translate(15));
    assertEquals(FIZZ_BUZZ, fizzBuzz.translate(30));
    assertEquals(FIZZ_BUZZ, fizzBuzz.translate(45));
  }

  @Test
  public void produceSequenceWithRangeShouldProduceString() {
    String oneToFive = "1 2 Fizz 4 Buzz";
    String oneToTen = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz";
    String oneToTwenty = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz";

    assertEquals(oneToFive, fizzBuzz.produceSequence(1, 5));
    assertEquals(oneToTen, fizzBuzz.produceSequence(1, 10));
    assertEquals(oneToTwenty, fizzBuzz.produceSequence(1, 20));

  }
}
