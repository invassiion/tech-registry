package com.example.techregistry.repository;

import com.example.techregistry.model.FridgeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeModelRepository extends JpaRepository<FridgeModel, Long> {
    List<FridgeModel> findByNameContainingIgnoreCase(String name);
    List<FridgeModel> findByColor(String color);
    List<FridgeModel> findByPriceBetween(double priceMin, double priceMax);
}