package com.example.demo.models.Mapper;

import com.example.demo.models.Box;
import com.example.demo.models.DTO.BoxDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoxMapper {
  BoxDTO toDTO(Box box);

  Box toEntity(BoxDTO boxDTO);

}
