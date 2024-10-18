package com.example.demo.controllers;

import com.example.demo.models.Box;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoxController {
  @GetMapping(value = "/box/{boxId}")
  public Box getBox(@PathVariable("boxId") Integer boxId) {
    Box box = new Box();
    return box;
  }

  @GetMapping(value = "/box")
  public ArrayList<Box> getBox() {
    return new ArrayList<>();
  }

  @PostMapping(value = "/box")
  public Box updateBox() {
    return new Box();
  }

  @PostMapping(value = "/box/{boxId}")
  public Box updateBox(@PathVariable("boxId") Integer boxId) {
    Box box = new Box();
    return box;
  }

  @DeleteMapping(value = "/box/{boxId}")
  public void deleteBox(@PathVariable("boxId") Integer boxId) {
  }
}
