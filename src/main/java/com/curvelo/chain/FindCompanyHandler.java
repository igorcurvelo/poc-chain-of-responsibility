package com.curvelo.chain;

import com.curvelo.chain.Customer.CustomerBuilder;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindCompanyHandler extends Handler {
  @Override
  public CustomerBuilder execute(CustomerBuilder builder) {
    log.info("execute: FindCompanyHandler");
    Faker faker = new Faker();
    return builder.company(faker.company().name());
  }

  @Override
  public void error(CustomerBuilder customer) {
    customer.failed(true);
    customer.step("company");
  }
}
