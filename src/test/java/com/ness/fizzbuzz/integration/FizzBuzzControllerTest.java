package com.ness.fizzbuzz.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getFizzBuzzSequenceWithCorrectParametersShouldReturnOk() throws Exception {
    mockMvc.perform(get("/fizzbuzz?start=1&end=10"))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.sequence", is("1 2 alfresco 4 buzz fizz 7 8 fizz buzz")))
      .andExpect(jsonPath("$.report", is("alfresco:1 integer:5 fizz:2 fizzbuzz:0 buzz:2")));
  }

  @Test
  public void getFizzBuzzSequenceWithIncorrectParametersShouldReturnOk() throws Exception {
    mockMvc.perform(get("/fizzbuzz?start=A&end=Z"))
      .andExpect(status().isBadRequest());
  }
}
