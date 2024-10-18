package com.example.demo.controllers;

import com.example.demo.models.Box;
import com.example.demo.models.DTO.BoxDTO;
import com.example.demo.models.Mapper.BoxMapper;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoxController {
  @GetMapping(value = "/box/{boxId}")
  public BoxDTO getBox(@PathVariable("boxId") Integer boxId) {
    return new BoxDTO();
  }

  @GetMapping(value = "/boxes")
  public ArrayList<BoxDTO> getAll() {
    ArrayList<BoxDTO> boxes = new ArrayList<>();
    return boxes;
  }

  @PostMapping(value = "/box")
  public BoxDTO addBox(@RequestBody Box box) {
    return BoxMapper.INSTANCE.toDTO(box);
  }


  @PostMapping(value = "/box/{boxId}")
  public BoxDTO updateBox(@PathVariable("boxId") Integer boxId) {
    return new BoxDTO();
  }

  @DeleteMapping(value = "/box/{boxId}")
  public void deleteBox(@PathVariable("boxId") Integer boxId) {
  }
}
