package com.example.demo.controllers;

import com.example.demo.models.Box;
import com.example.demo.models.DTO.BoxDTO;
import com.example.demo.models.Mapper.BoxMapper;
import com.example.demo.services.BoxService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boxes")
public class BoxController {

    @Autowired
    private BoxService boxService;

    @GetMapping("/{boxId}")
    public BoxDTO getBox(@PathVariable("boxId") Integer boxId) {
        return BoxMapper.INSTANCE.toDTO(boxService.getById(boxId));
    }

    @GetMapping
    public List<BoxDTO> getAll() {
      List<Box> boxes = boxService.getAll();
      ArrayList<BoxDTO> boxesDTO = new ArrayList<>();
      for (Box box : boxes) {
          boxesDTO.add(BoxMapper.INSTANCE.toDTO(box));
      }
      return boxesDTO;
    }

    @PostMapping
    public ResponseEntity<BoxDTO> addBox(@RequestBody Box box) {
        try {
            return ResponseEntity.ok(BoxMapper.INSTANCE.toDTO(boxService.create(box)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{boxId}")
    public BoxDTO updateBox(@PathVariable("boxId") Integer boxId, @RequestBody Box box) {
        return BoxMapper.INSTANCE.toDTO(boxService.update(box, boxId));
    }

    @DeleteMapping("/{boxId}")
    public void deleteBox(@PathVariable("boxId") Integer boxId) {
        boxService.delete(boxId);
    }
}