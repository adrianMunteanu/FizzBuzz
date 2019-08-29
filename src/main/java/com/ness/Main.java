package com.ness;

import com.ness.service.FizzBuzzSerivce;

public class Main {
  public static void main(String[] args) {
    FizzBuzzSerivce fizzBuzz = new FizzBuzzSerivce();
    System.out.println(fizzBuzz.produceSequence(1,20));
  }
}
