package com.curvelo.chain;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Customer {
  private final String firstName;
  private final String lastName;
  private final String company;
  private final boolean failed;
  private final String step;
}
