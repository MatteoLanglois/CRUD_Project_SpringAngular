package com.example.demo.models.Mapper;

import com.example.demo.models.DTO.UserDTO;
import com.example.demo.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "nom", target = "nom")
  @Mapping(source = "prenom", target = "prenom")
  @Mapping(source = "mail", target = "mail")
  @Mapping(source = "password", target = "password")
  @Mapping(source = "username", target = "username")
  UserDTO toDTO(User user);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "nom", target = "nom")
  @Mapping(source = "prenom", target = "prenom")
  @Mapping(source = "mail", target = "mail")
  @Mapping(source = "password", target = "password")
  @Mapping(source = "username", target = "username")
  User toEntity(UserDTO userDTO);
}
