package com.spitter.domain;

import lombok.Data;

@Data
public class Spitter {
  
  private Long id;
  private String username;
  private String password;
  private String fullName;
  private String email;
  private boolean updateByEmail;

  public Spitter(Long id, String username, String password, String fullName, String email, boolean updateByEmail) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.fullName = fullName;
    this.email = email;
    this.updateByEmail = updateByEmail;
  }


  public Spitter() {

  }
}
