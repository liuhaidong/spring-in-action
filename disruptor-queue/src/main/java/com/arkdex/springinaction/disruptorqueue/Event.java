package com.arkdex.springinaction.disruptorqueue;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Event<T> {

  private T payload;
}
