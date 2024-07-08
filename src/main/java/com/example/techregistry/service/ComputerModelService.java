package com.example.techregistry.service;


import com.example.techregistry.model.ComputerModel;
import com.example.techregistry.repository.ComputerModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ComputerModelService {

    private final ComputerModelRepository computerModelRepository;

    public List<ComputerModel> getAllComputerModels() {
        return computerModelRepository.findAll();
    }

    public ComputerModel getComputerModelById(Long id) {
        return computerModelRepository.findById(id).orElse(null);
    }

    public ComputerModel createComputerModel(ComputerModel computerModel) {
        return computerModelRepository.save(computerModel);
    }

    public void deleteComputerModel(Long id) {
        computerModelRepository.deleteById(id);
    }

    public List<ComputerModel> searchComputerModelByName(String name) {
        return computerModelRepository.findByNameContainingIgnoreCase(name);
    }

    public List<ComputerModel> filterComputerModelsByColor(String color) {
        return computerModelRepository.findByColor(color);
    }

    public List<ComputerModel> filterComputerModelsByPriceRange(double priceMin, double priceMax) {
        return computerModelRepository.findByPriceBetween(priceMin, priceMax);
    }
}
