package com.curvelo.chain;

import org.junit.jupiter.api.Test;

class ChainTest {

  @Test
  void run() {
    final var findFirstName = new FindFirstNameHandler();
    final var findLastName = new FindLastNameHandler();
    final var findCompany = new FindCompanyHandler();
    findFirstName.addNext(findLastName).addNext(findCompany);

    final var builder = new Customer.CustomerBuilder();

    Customer.CustomerBuilder result = findFirstName.handle(builder);
    System.out.println(result.build());
  }

}