package com.example.demo.models.Mapper;

import com.example.demo.models.Box;
import com.example.demo.models.DTO.BoxDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BoxMapper {
  BoxMapper INSTANCE = Mappers.getMapper(BoxMapper.class);

  BoxDTO toDTO(Box box);

  Box toEntity(BoxDTO boxDTO);

}
