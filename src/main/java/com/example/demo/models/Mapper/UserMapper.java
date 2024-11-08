package com.example.demo.models.Mapper;

import com.example.demo.models.DTO.UserDTO;
import com.example.demo.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserDTO toDTO(User user);

  User toEntity(UserDTO userDTO);
}
