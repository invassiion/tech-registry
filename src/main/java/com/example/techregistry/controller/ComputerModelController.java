package com.example.techregistry.controller;


import com.example.techregistry.model.ComputerModel;
import com.example.techregistry.model.SmartphoneModel;
import com.example.techregistry.service.ComputerModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/computermodels")
public class ComputerModelController {

    private final ComputerModelService computerModelService;

    @GetMapping
    public List<ComputerModel> getAllComputer() {
        return computerModelService.getAllComputerModels();
    }

    @GetMapping("/{id}")
    public ComputerModel getComputerModelById(@PathVariable Long id) {
        return computerModelService.getComputerModelById(id);
    }

    @PostMapping
    public ComputerModel createComputerModel(@RequestBody ComputerModel computerModel) {
        return computerModelService.createComputerModel(computerModel);
    }

    @DeleteMapping("/{id}")
    public void deleteComputerModel(@PathVariable Long id) {
        computerModelService.deleteComputerModel(id);
    }

    @GetMapping("/search")
    public List<ComputerModel> searchComputerModelByName(@RequestParam String name) {
        return computerModelService.searchComputerModelByName(name);
    }

    @GetMapping("/filter")
    public List<ComputerModel> filterComputerModels(@RequestParam(required = false) String color,
                                                    @RequestParam(required = false) Double priceMin,
                                                    @RequestParam(required = false) Double priceMax) {
        if (color != null) {
            return computerModelService.filterComputerModelsByColor(color);
        } else if (priceMin != null && priceMax != null) {
            return computerModelService.filterComputerModelsByPriceRange(priceMin, priceMax);
        } else {
            return computerModelService.getAllComputerModels();
        }
    }
}
