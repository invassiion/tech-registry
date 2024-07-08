package com.example.techregistry.service;

import com.example.techregistry.model.VacuumModel;
import com.example.techregistry.repository.VacuumModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class VacuumModelService {

    private final VacuumModelRepository vacuumModelRepository;

    public List<VacuumModel> getAllVacuumModels() {
        return vacuumModelRepository.findAll();
    }
    public VacuumModel getVacuumModelById(Long id) {
        return vacuumModelRepository.findById(id).orElse(null);
    }

    public VacuumModel createVacuumModel(VacuumModel vacuumModel) {
        return vacuumModelRepository.save(vacuumModel);
    }

    public void deleteVacuumModel(Long id) {
        vacuumModelRepository.deleteById(id);
    }

    public List<VacuumModel> searchVacuumModelByName(String name) {
        return vacuumModelRepository.findByNameContainingIgnoreCase(name);
    }

    public List<VacuumModel> filterVacuumModelsByColor(String color) {
        return vacuumModelRepository.findByColor(color);
    }

    public List<VacuumModel> filterVacuumModelsByPriceRange(double priceMin, double priceMax) {
        return vacuumModelRepository.findByPriceBetween(priceMin, priceMax);
    }
}
