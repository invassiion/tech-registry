package com.example.techregistry.controller;

import com.example.techregistry.model.SmartphoneModel;
import com.example.techregistry.service.SmartphoneModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/smartphonemodels")
public class SmartphoneModelController {
    private final SmartphoneModelService smartphoneModelService;



    @GetMapping
    public List<SmartphoneModel> getAllSmartphoneModels() {
        return smartphoneModelService.getAllSmartphoneModels();
    }

    @GetMapping("/{id}")
    public SmartphoneModel getSmartphoneModelById(@PathVariable Long id) {
        return smartphoneModelService.getSmartphoneModelById(id);
    }

    @PostMapping
    public SmartphoneModel createSmartphoneModel(@RequestBody SmartphoneModel smartphoneModel) {
        return smartphoneModelService.createSmartphoneModel(smartphoneModel);
    }

    @DeleteMapping("/{id}")
    public void deleteSmartphoneModel(@PathVariable Long id) {
        smartphoneModelService.deleteSmartphoneModel(id);
    }

    @GetMapping("/search")
    public List<SmartphoneModel> searchSmartphoneModelByName(@RequestParam String name) {
        return smartphoneModelService.searchSmartphoneModelByName(name);
    }

    @GetMapping("/filter")
    public List<SmartphoneModel> filterSmartphoneModels(@RequestParam(required = false) String color,
                                                        @RequestParam(required = false) Double priceMin,
                                                        @RequestParam(required = false) Double priceMax) {
        if (color != null) {
            return smartphoneModelService.filterSmartphoneModelsByColor(color);
        } else if (priceMin != null && priceMax != null) {
            return smartphoneModelService.filterSmartphoneModelsByPriceRange(priceMin, priceMax);
        } else {
            return smartphoneModelService.getAllSmartphoneModels();
        }
    }
}