package com.example.demo.models.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserConnectionDTO {
  private String email;
  private String password;
}
