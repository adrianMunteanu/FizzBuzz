package com.ness.model;

import java.util.Objects;

public class FizzBuzzResponse {
  private String sequence;
  private String report;

  public FizzBuzzResponse() {

  }

  public FizzBuzzResponse(String sequence, String report) {
    this.sequence = sequence;
    this.report = report;
  }

  public String getSequence() {
    return sequence;
  }

  public void setSequence(String sequence) {
    this.sequence = sequence;
  }

  public String getReport() {
    return report;
  }

  public void setReport(String report) {
    this.report = report;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FizzBuzzResponse that = (FizzBuzzResponse) o;
    return Objects.equals(sequence, that.sequence) && Objects.equals(report, that.report);
  }

  @Override
  public int hashCode() {

    return Objects.hash(sequence, report);
  }
}
