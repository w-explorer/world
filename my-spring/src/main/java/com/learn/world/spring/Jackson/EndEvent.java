package com.learn.world.spring.Jackson;

import lombok.Data;
import lombok.ToString;

@ToString(callSuper = true)
@Data
public class EndEvent extends BaseElement{

  private String endEvent;

  private String endInfo;
}
