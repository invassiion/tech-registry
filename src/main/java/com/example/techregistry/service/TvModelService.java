package com.example.techregistry.service;
import com.example.techregistry.model.TvModel;
import com.example.techregistry.repository.TvModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TvModelService {

    private final TvModelRepository tvModelRepository;

    public List<TvModel> getAllTvModels() {
        return tvModelRepository.findAll();
    }

    public TvModel getTvModelById(Long id) {
        return tvModelRepository.findById(id).orElse(null);
    }

    public TvModel createTvModel(TvModel tvModel) {
        return tvModelRepository.save(tvModel);
    }

    public void deleteTvModel(Long id) {
        tvModelRepository.deleteById(id);
    }

    public List<TvModel> searchTvModelByName(String name) {
        return tvModelRepository.findByNameContainingIgnoreCase(name);
    }

    public List<TvModel> filterTvModelsByColor(String color) {
        return tvModelRepository.findByColor(color);
    }

    public List<TvModel> filterTvModelsByPriceRange(double priceMin, double priceMax) {
        return tvModelRepository.findByPriceBetween(priceMin, priceMax);
    }
}
