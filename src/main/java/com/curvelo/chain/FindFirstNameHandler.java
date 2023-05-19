package com.curvelo.chain;

import com.curvelo.chain.Customer.CustomerBuilder;
import com.github.javafaker.Faker;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindFirstNameHandler extends Handler {
  @Override
  public CustomerBuilder execute(CustomerBuilder builder) {
    log.info("execute: FindFirstNameHandler");
    Faker faker = new Faker();
    return builder.firstName(faker.name().firstName());
  }

  @Override
  public void error(CustomerBuilder customer) {
    customer.failed(true);
    customer.step("first name");
  }
}

