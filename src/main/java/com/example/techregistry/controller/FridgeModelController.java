package com.example.techregistry.controller;

import com.example.techregistry.model.FridgeModel;
import com.example.techregistry.service.FridgeModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fridgemodels")
public class FridgeModelController {
    private final FridgeModelService fridgeModelService;



    @GetMapping
    public List<FridgeModel> getAllFridgeModels() {
        return fridgeModelService.getAllFridgeModels();
    }

    @GetMapping("/{id}")
    public FridgeModel getFridgeModelById(@PathVariable Long id) {
        return fridgeModelService.getFridgeModelById(id);
    }

    @PostMapping
    public FridgeModel createFridgeModel(@RequestBody FridgeModel fridgeModel) {
        return fridgeModelService.createFridgeModel(fridgeModel);
    }

    @DeleteMapping("/{id}")
    public void deleteFridgeModel(@PathVariable Long id) {
        fridgeModelService.deleteFridgeModel(id);
    }

    @GetMapping("/search")
    public List<FridgeModel> searchFridgeModelByName(@RequestParam String name) {
        return fridgeModelService.searchFridgeModelByName(name);
    }

    @GetMapping("/filter")
    public List<FridgeModel> filterFridgeModels(@RequestParam(required = false) String color,
                                                @RequestParam(required = false) Double priceMin,
                                                @RequestParam(required = false) Double priceMax) {
        if (color != null) {
            return fridgeModelService.filterFridgeModelsByColor(color);
        } else if (priceMin != null && priceMax != null) {
            return fridgeModelService.filterFridgeModelsByPriceRange(priceMin, priceMax);
        } else {
            return fridgeModelService.getAllFridgeModels();
        }
    }
}