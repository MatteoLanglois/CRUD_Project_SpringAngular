package com.example.demo.models.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDTO {
  private Integer userId;
  private String userNom;
  private String userPrenom;
  private String email;
  private String password;
  private String username;
}
