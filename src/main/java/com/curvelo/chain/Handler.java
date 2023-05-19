package com.curvelo.chain;

import com.curvelo.chain.Customer.CustomerBuilder;
import java.util.Objects;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Handler {
  protected Handler next;
  public CustomerBuilder handle(final CustomerBuilder builder) {
    try {
      // force random error
      if(new Random().nextInt(10) <= 2) {
        throw new RuntimeException();
      }

      execute(builder);
      if (Objects.nonNull(this.next)) return this.next.handle(builder);
    } catch (Exception e) {
      log.error(e.getMessage());
      error(builder);
    }
    return builder;
  }

  public abstract CustomerBuilder execute(final CustomerBuilder customer);

  public abstract void error(final CustomerBuilder customer);

  public Handler addNext(final Handler handler) {
    this.next = handler;
    return handler;
  }

}
