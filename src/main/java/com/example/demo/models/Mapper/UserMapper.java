package com.example.demo.models.Mapper;

import com.example.demo.models.DTO.UserDTO;
import com.example.demo.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
  UserDTO userToUserDTO(User user);
  
}
