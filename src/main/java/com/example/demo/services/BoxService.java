package com.example.demo.services;

import com.example.demo.models.Box;
import com.example.demo.repository.BoxRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoxService {
  @Autowired
  private BoxRepository repository;

  @Transactional
  public Box create(Box box) {
    return repository.save(box);
  }

  public Box getById(int id) {
    return repository.findById(id).orElse(null);
  }

  public List<Box> getAll() {
    return repository.findAll();
  }

  @Transactional
  public Box update(Box box, int id) {
    Box existingBox = repository.findById(id).orElseThrow(() -> new RuntimeException("Box not found"));
    existingBox.setNom(box.getNom());
    existingBox.setDescription(box.getDescription());
    existingBox.setQuantite(box.getQuantite());
    existingBox.setPoint_geo(existingBox.getPoint_geo());
    return repository.save(existingBox);
  }

  @Transactional
  public void delete(int id) {
    repository.deleteById(id);
  }
}