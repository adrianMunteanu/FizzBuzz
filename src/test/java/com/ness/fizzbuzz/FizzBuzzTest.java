package com.ness.fizzbuzz;

import com.ness.FizzBuzz;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

  private FizzBuzz fizzBuzz = new FizzBuzz();
  private static final String FIZZ = "fizz";
  private static final String BUZZ = "buzz";
  private static final String FIZZ_BUZZ = "fizzbuzz";
  private static final String ALFRESCO = "alfresco";

  @Test
  public void translateWithNonMultipleNumbersShouldReturnThoseNumbers() {
    assertEquals("1", fizzBuzz.translate(1));
    assertEquals("2", fizzBuzz.translate(2));
  }

  @Test
  public void translateWithContainingThreeShouldReturnAlfresco() {
    assertEquals(ALFRESCO, fizzBuzz.translate(3));
    assertEquals(ALFRESCO, fizzBuzz.translate(13));
    assertEquals(ALFRESCO, fizzBuzz.translate(30));
  }

  @Test
  public void translateWithMultipleOfThreeShouldReturnFizz() {
    assertEquals(ALFRESCO, fizzBuzz.translate(3));
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
    assertEquals(ALFRESCO, fizzBuzz.translate(30));
    assertEquals(FIZZ_BUZZ, fizzBuzz.translate(45));
  }

  @Test
  public void produceSequenceWithRangeShouldProduceString() {
    String oneToFive = "1 2 alfresco 4 buzz" + System.lineSeparator() + "alfresco:1 integer:3 fizz:0 fizzbuzz:0 buzz:1";
    String oneToTen = "1 2 alfresco 4 buzz fizz 7 8 fizz buzz" + System.lineSeparator() + "alfresco:1 integer:5 fizz:2 fizzbuzz:0 buzz:2";
    String oneToTwenty = "1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz"
      + System.lineSeparator() + "alfresco:2 integer:10 fizz:4 fizzbuzz:1 buzz:3";

    assertEquals(oneToFive, fizzBuzz.produceSequence(1, 5));
    assertEquals(oneToTen, fizzBuzz.produceSequence(1, 10));
    assertEquals(oneToTwenty, fizzBuzz.produceSequence(1, 20));
  }
}
