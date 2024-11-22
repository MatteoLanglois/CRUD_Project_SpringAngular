package com.example.demo.controllers;

import com.example.demo.models.Box;
import com.example.demo.models.DTO.BoxDTO;
import com.example.demo.models.Mapper.BoxMapper;
import com.example.demo.services.BoxService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoxController {

    @Autowired
    private BoxService boxService;

    @GetMapping("/boxes/{boxId}")
    public BoxDTO getBox(@PathVariable("boxId") Integer boxId) {
        return BoxMapper.INSTANCE.toDTO(boxService.getById(boxId));
    }

    @GetMapping("/boxes")
    public List<BoxDTO> getAll() {
        return boxService.getAll().stream()
                .map(BoxMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }


    @PostMapping("/boxes")
    public ResponseEntity<BoxDTO> addBox(@RequestBody Box box) {
        try {
            return ResponseEntity.ok(BoxMapper.INSTANCE.toDTO(boxService.create(box)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/boxes/{boxId}")
    public BoxDTO updateBox(@PathVariable("boxId") Integer boxId, @RequestBody Box box) {
        return BoxMapper.INSTANCE.toDTO(boxService.update(box, boxId));
    }

    @DeleteMapping("/boxes/{boxId}")
    public void deleteBox(@PathVariable("boxId") Integer boxId) {
        boxService.delete(boxId);
    }
}