package com.example.techregistry.service;


import com.example.techregistry.model.FridgeModel;
import com.example.techregistry.repository.FridgeModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FridgeModelService {

    private final FridgeModelRepository fridgeModelRepository;

    public List<FridgeModel> getAllFridgeModels() {
        return fridgeModelRepository.findAll();
    }

    public FridgeModel getFridgeModelById(Long id) {
        return fridgeModelRepository.findById(id).orElse(null);
    }

    public FridgeModel createFridgeModel(FridgeModel fridgeModel) {
        return fridgeModelRepository.save(fridgeModel);
    }

    public void deleteFridgeModel(Long id) {
        fridgeModelRepository.deleteById(id);
    }

    public List<FridgeModel> searchFridgeModelByName(String name) {
        return fridgeModelRepository.findByNameContainingIgnoreCase(name);
    }

    public List<FridgeModel> filterFridgeModelsByColor(String color) {
        return fridgeModelRepository.findByColor(color);
    }

    public List<FridgeModel> filterFridgeModelsByPriceRange(double priceMin, double priceMax) {
        return fridgeModelRepository.findByPriceBetween(priceMin, priceMax);
    }
}
