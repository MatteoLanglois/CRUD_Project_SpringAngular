package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.checkerframework.common.aliasing.qual.Unique;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "utilisateur")
public class User {
  @Id
  @GeneratedValue(strategy  = GenerationType.IDENTITY)
  private Integer id;

  @NonNull
  private String nom;

  @NonNull
  private String prenom;

  @NonNull
  private String mail;

  @NonNull
  private String password;

  @NonNull
  @Unique
  private String username;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Reservation> reservations;

}
