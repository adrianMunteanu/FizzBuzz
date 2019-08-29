package com.ness.controller;

import com.ness.model.FizzBuzzResponse;
import com.ness.service.FizzBuzzSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FizzBuzzController {

  private FizzBuzzSerivce fizzBuzzSerivce;

  @Autowired
  public void setFizzBuzzSerivce(FizzBuzzSerivce fizzBuzzSerivce) {
    this.fizzBuzzSerivce = fizzBuzzSerivce;
  }

  @GetMapping("/fizzbuzz")
  @ResponseBody
  public FizzBuzzResponse getFizzBuzzSequence(@RequestParam int start, @RequestParam int end) {
    return fizzBuzzSerivce.produceSequence(start, end);
  }
}
