package com.example.demo.services;

import com.example.demo.models.Box;
import com.example.demo.models.DTO.BoxDTO;
import com.example.demo.models.Mapper.BoxMapper;
import com.example.demo.repository.BoxRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoxService {
  @Autowired
  private BoxRepository repository;

  @Transactional
  public BoxDTO create(Box box) {
    return BoxMapper.INSTANCE.toDTO(repository.save(box));
  }

  public BoxDTO findById(int id) {
    return repository.findById(id).map(BoxMapper.INSTANCE::toDTO).orElse(null);
  }

  public List<BoxDTO> findAll() {
    List<Box> list = repository.findAll();
    List<BoxDTO> listDTO = new ArrayList<>();
    for (Box box : list) {
      listDTO.add(BoxMapper.INSTANCE.toDTO(box));
    }
    return listDTO;
  }

  @Transactional
  public BoxDTO update(Box box) {
    return BoxMapper.INSTANCE.toDTO(repository.save(box));
  }

  @Transactional
  public void delete(int id) {
    repository.deleteById(id);
  }
}
