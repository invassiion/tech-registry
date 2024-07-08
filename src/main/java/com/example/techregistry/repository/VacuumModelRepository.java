package com.example.techregistry.repository;

import com.example.techregistry.model.VacuumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacuumModelRepository extends JpaRepository<VacuumModel, Long> {
    List<VacuumModel> findByNameContainingIgnoreCase(String name);
    List<VacuumModel> findByColor(String color);
    List<VacuumModel> findByPriceBetween(double priceMin, double priceMax);
}
