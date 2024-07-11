package com.example.techregistry.controller;


import com.example.techregistry.configuration.BaseRoutes;
import com.example.techregistry.model.ComputerModel;
import com.example.techregistry.model.SmartphoneModel;
import com.example.techregistry.service.ComputerModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(BaseRoutes.COMPUTER)
public class ComputerModelController {

    private final ComputerModelService computerModelService;

    @Operation(summary = "Получить все модели компьютеров", description = "Возвращает список всех моделей компьютеров")
    @ApiResponse(responseCode = "200", description = "Список моделей компьютеров",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ComputerModel.class),
                    examples = @ExampleObject(name = "Пример модели компьютера", value = "{\n" +
                            "  \"name\": \"Dell Inspiron\",\n" +
                            "  \"serialNumber\": \"PC1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"15.6 дюймов\",\n" +
                            "  \"price\": 1099.99,\n" +
                            "  \"category\": \"Ноутбук\",\n" +
                            "  \"processorType\": \"Intel i7\",\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @GetMapping
    public List<ComputerModel> getAllComputer() {
        return computerModelService.getAllComputerModels();
    }

    @Operation(summary = "Получить модель компьютера по ID", description = "Возвращает модель компьютера по ID")
    @ApiResponse(responseCode = "200", description = "Модель компьютера найдена",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ComputerModel.class),
                    examples = @ExampleObject(name = "Пример модели компьютера", value = "{\n" +
                            "  \"name\": \"Dell Inspiron\",\n" +
                            "  \"serialNumber\": \"PC1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"15.6 дюймов\",\n" +
                            "  \"price\": 1099.99,\n" +
                            "  \"category\": \"Ноутбук\",\n" +
                            "  \"processorType\": \"Intel i7\",\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @GetMapping(BaseRoutes.BY_ID)
    public ComputerModel getComputerModelById(@PathVariable Long id) {
        return computerModelService.getComputerModelById(id);
    }

    @Operation(summary = "Создать новую модель компьютера", description = "Создает новую модель компьютера и возвращает её")
    @ApiResponse(responseCode = "201", description = "Модель компьютера создана",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ComputerModel.class),
                    examples = @ExampleObject(name = "Пример создания модели компьютера", value = "{\n" +
                            "  \"name\": \"Dell Inspiron\",\n" +
                            "  \"serialNumber\": \"PC1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"15.6 дюймов\",\n" +
                            "  \"price\": 1099.99,\n" +
                            "  \"category\": \"Ноутбук\",\n" +
                            "  \"processorType\": \"Intel i7\",\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @PostMapping
    public ComputerModel createComputerModel(@RequestBody ComputerModel computerModel) {
        return computerModelService.createComputerModel(computerModel);
    }

    @Operation(summary = "Удалить модель компьютера по ID", description = "Удаляет модель компьютера по ID")
    @ApiResponse(responseCode = "204", description = "Модель компьютера удалена")
    @DeleteMapping(BaseRoutes.BY_ID)
    public void deleteComputerModel(@PathVariable Long id) {
        computerModelService.deleteComputerModel(id);
    }

    @Operation(summary = "Поиск модели компьютера по наименованию", description = "Ищет модель компьютера по наименованию")
    @ApiResponse(responseCode = "200", description = "Список найденных моделей компьютеров",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ComputerModel.class),
                    examples = @ExampleObject(name = "Пример поиска модели компьютера", value = "[{\n" +
                            "  \"name\": \"Dell Inspiron\",\n" +
                            "  \"serialNumber\": \"PC1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"15.6 дюймов\",\n" +
                            "  \"price\": 1099.99,\n" +
                            "  \"category\": \"Ноутбук\",\n" +
                            "  \"processorType\": \"Intel i7\",\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.SEARCH)
    public List<ComputerModel> searchComputerModelByName(@RequestParam String name) {
        return computerModelService.searchComputerModelByName(name);
    }

    @Operation(summary = "Фильтрация моделей компьютеров", description = "Фильтрует модели компьютеров по различным критериям")
    @ApiResponse(responseCode = "200", description = "Список отфильтрованных моделей компьютеров",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ComputerModel.class),
                    examples = @ExampleObject(name = "Пример фильтрации моделей компьютеров", value = "[{\n" +
                            "  \"name\": \"Dell Inspiron\",\n" +
                            "  \"serialNumber\": \"PC1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"15.6 дюймов\",\n" +
                            "  \"price\": 1099.99,\n" +
                            "  \"category\": \"Ноутбук\",\n" +
                            "  \"processorType\": \"Intel i7\",\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.FILTER)
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
