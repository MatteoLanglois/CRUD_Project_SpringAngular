package com.example.demo.services;
import com.example.demo.models.Box;
import com.example.demo.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoxService {
    @Autowired
    private BoxRepository boxRepository;

    public List<Box> getAllBoxes() {
        return boxRepository.findAll();
    }
    public Box getBoxById(int id) {
        return boxRepository.findById(id).orElse(null);

    }
    public Box saveBox(Box box) {
        return boxRepository.save(box);
    }
    public void deleteBoxById(int id) {
        boxRepository.deleteById(id);
    }


}
