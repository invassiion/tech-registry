package com.example.techregistry.repository;

import com.example.techregistry.model.SmartphoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartphoneModelRepository extends JpaRepository<SmartphoneModel, Long> {
    List<SmartphoneModel> findByNameContainingIgnoreCase(String name);
    List<SmartphoneModel> findByColor(String color);
    List<SmartphoneModel> findByPriceBetween(double priceMin, double priceMax);
}