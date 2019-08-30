package com.ness.exception;

public class IncorrectRangeException extends RuntimeException {
  public IncorrectRangeException(String errorMessage) {
    super(errorMessage);
  }
}
