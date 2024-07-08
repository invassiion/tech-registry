package com.example.techregistry.repository;

import com.example.techregistry.model.ComputerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerModelRepository extends JpaRepository<ComputerModel, Long> {
    List<ComputerModel> findByNameContainingIgnoreCase(String name);
    List<ComputerModel> findByColor(String color);
    List<ComputerModel> findByPriceBetween(double priceMin, double priceMax);
}