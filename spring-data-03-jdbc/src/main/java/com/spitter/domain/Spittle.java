package com.spitter.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Spittle {
  private final Long id;
  private final Spitter spitter;
  private final String message;
  private final Date postedTime;

  public Spittle(Long id, Spitter spitter, String message, Date postedTime) {
    this.id = id;
    this.spitter = spitter;
    this.message = message;
    this.postedTime = postedTime;
  }

}
