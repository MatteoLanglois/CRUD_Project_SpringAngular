package com.example.demo.models.Mapper;

import com.example.demo.models.Box;
import com.example.demo.models.DTO.BoxDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BoxMapper {
  BoxMapper INSTANCE = Mappers.getMapper(BoxMapper.class);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "nom", target = "nom")
  @Mapping(source = "quantite", target = "quantite")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "point_geo", target = "point_geo")
  BoxDTO toDTO(Box box);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "nom", target = "nom")
  @Mapping(source = "quantite", target = "quantite")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "point_geo", target = "point_geo")
  Box toEntity(BoxDTO boxDTO);

}
