package com.example.techregistry.controller;


import com.example.techregistry.model.TvModel;
import com.example.techregistry.service.TvModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tvmodels")
public class TvModelController {


    private final TvModelService tvModelService;

    @GetMapping
    public List<TvModel> getAllTvModels() {
        return tvModelService.getAllTvModels();
    }

    @GetMapping("/{id}")
    public TvModel getTvModelById(@PathVariable Long id) {
        return tvModelService.getTvModelById(id);
    }

    @PostMapping
    public TvModel createTvModel(@RequestBody TvModel tvModel) {
        return tvModelService.createTvModel(tvModel);
    }

    @DeleteMapping("/{id}")
    public void deleteTvModel(@PathVariable Long id) {
        tvModelService.deleteTvModel(id);
    }

    @GetMapping("/search")
    public List<TvModel> searchTvModelByName(@RequestParam String name) {
        return tvModelService.searchTvModelByName(name);
    }

    @GetMapping("/filter")
    public List<TvModel> filterTvModels(@RequestParam(required = false) String color,
                                        @RequestParam(required = false) Double priceMin,
                                        @RequestParam(required = false) Double priceMax) {
        if (color != null) {
            return tvModelService.filterTvModelsByColor(color);
        } else if (priceMin != null && priceMax != null) {
            return tvModelService.filterTvModelsByPriceRange(priceMin, priceMax);
        } else {
            return tvModelService.getAllTvModels();
        }
    }
}
