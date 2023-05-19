package com.curvelo.chain;

import com.curvelo.chain.Customer.CustomerBuilder;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindLastNameHandler extends Handler {
  @Override
  public CustomerBuilder execute(CustomerBuilder builder) {
    log.info("execute: FindLastNameHandler");
    Faker faker = new Faker();
    return builder.lastName(faker.name().lastName());
  }

  @Override
  public void error(CustomerBuilder customer) {
    customer.failed(true);
    customer.step("last name");
  }
}
