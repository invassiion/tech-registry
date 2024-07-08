package com.example.techregistry.repository;

import com.example.techregistry.model.TvModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvModelRepository extends JpaRepository<TvModel, Long> {
    List<TvModel> findByNameContainingIgnoreCase(String name);
    List<TvModel> findByColor(String color);
    List<TvModel> findByPriceBetween(double priceMin, double priceMax);
}