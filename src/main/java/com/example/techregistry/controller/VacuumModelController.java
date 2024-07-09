package com.example.techregistry.controller;


import com.example.techregistry.model.VacuumModel;
import com.example.techregistry.service.VacuumModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vacuummodels")
public class VacuumModelController {

    private final VacuumModelService vacuumModelService;

    @GetMapping
    public List<VacuumModel> getAllVacuumModels() {
        return vacuumModelService.getAllVacuumModels();
    }

    @GetMapping("/{id}")
    public VacuumModel getVacuumModelById(@PathVariable Long id) {
        return vacuumModelService.getVacuumModelById(id);
    }

    @PostMapping
    public VacuumModel createVacuumModel(@RequestBody VacuumModel vacuumModel) {
        return vacuumModelService.createVacuumModel(vacuumModel);
    }

    @DeleteMapping("/{id}")
    public void deleteVacuumModel(@PathVariable Long id) {
        vacuumModelService.deleteVacuumModel(id);
    }

    @GetMapping("/search")
    public List<VacuumModel> searchVacuumModelByName(@RequestParam String name) {
        return vacuumModelService.searchVacuumModelByName(name);
    }

    @GetMapping("/filter")
    public List<VacuumModel> filterVacuumModels(@RequestParam(required = false) String color,
                                                @RequestParam(required = false) Double priceMin,
                                                @RequestParam(required = false) Double priceMax) {
        if (color != null) {
            return vacuumModelService.filterVacuumModelsByColor(color);
        } else if (priceMin != null && priceMax != null) {
            return vacuumModelService.filterVacuumModelsByPriceRange(priceMin, priceMax);
        } else {
            return vacuumModelService.getAllVacuumModels();
        }
    }
}
