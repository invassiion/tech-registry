package com.example.techregistry.service;


import com.example.techregistry.model.SmartphoneModel;
import com.example.techregistry.repository.SmartphoneModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SmartphoneModelService {

    private final SmartphoneModelRepository smartphoneModelRepository;
    public List<SmartphoneModel> getAllSmartphoneModels() {
        return smartphoneModelRepository.findAll();
    }

    public SmartphoneModel getSmartphoneModelById(Long id) {
        return smartphoneModelRepository.findById(id).orElse(null);
    }

    public SmartphoneModel createSmartphoneModel(SmartphoneModel smartphoneModel) {
        return smartphoneModelRepository.save(smartphoneModel);
    }

    public void deleteSmartphoneModel(Long id) {
        smartphoneModelRepository.deleteById(id);
    }

    public List<SmartphoneModel> searchSmartphoneModelByName(String name) {
        return smartphoneModelRepository.findByNameContainingIgnoreCase(name);
    }

    public List<SmartphoneModel> filterSmartphoneModelsByColor(String color) {
        return smartphoneModelRepository.findByColor(color);
    }

    public List<SmartphoneModel> filterSmartphoneModelsByPriceRange(double priceMin, double priceMax) {
        return smartphoneModelRepository.findByPriceBetween(priceMin, priceMax);
    }

}
