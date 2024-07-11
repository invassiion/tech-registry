package com.example.techregistry.controller;

import com.example.techregistry.configuration.BaseRoutes;
import com.example.techregistry.model.SmartphoneModel;
import com.example.techregistry.service.SmartphoneModelService;
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
@RequestMapping(BaseRoutes.SMARTPHONE)
public class SmartphoneModelController {
    private final SmartphoneModelService smartphoneModelService;



    @Operation(summary = "Получить все модели смартфонов", description = "Возвращает список всех моделей смартфонов")
    @ApiResponse(responseCode = "200", description = "Список моделей смартфонов",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = SmartphoneModel.class),
                    examples = @ExampleObject(name = "Пример модели смартфона", value = "{\n" +
                            "  \"name\": \"iPhone 12\",\n" +
                            "  \"serialNumber\": \"SM1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"6.1 дюймов\",\n" +
                            "  \"price\": 999.99,\n" +
                            "  \"memory\": \"128 GB\",\n" +
                            "  \"camerasCount\": 2,\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @GetMapping
    public List<SmartphoneModel> getAllSmartphoneModels() {
        return smartphoneModelService.getAllSmartphoneModels();
    }

    @Operation(summary = "Получить модель смартфона по ID", description = "Возвращает модель смартфона по ID")
    @ApiResponse(responseCode = "200", description = "Модель смартфона найдена",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = SmartphoneModel.class),
            examples = @ExampleObject(name = "Пример модели смартфона", value = "{\n" +
                    "  \"name\": \"iPhone 12\",\n" +
                    "  \"serialNumber\": \"SM1234567890\",\n" +
                    "  \"color\": \"Черный\",\n" +
                    "  \"size\": \"6.1 дюймов\",\n" +
                    "  \"price\": 999.99,\n" +
                    "  \"memory\": \"128 GB\",\n" +
                    "  \"camerasCount\": 2,\n" +
                    "  \"inStock\": true\n" +
                    "}")))
    @GetMapping(BaseRoutes.BY_ID)
    public SmartphoneModel getSmartphoneModelById(@PathVariable Long id) {
        return smartphoneModelService.getSmartphoneModelById(id);
    }

    @Operation(summary = "Создать новую модель смартфона", description = "Создает новую модель смартфона и возвращает её")
    @ApiResponse(responseCode = "201", description = "Модель смартфона создана",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = SmartphoneModel.class),
                    examples = @ExampleObject(name = "Пример создания модели смартфона", value = "{\n" +
                            "  \"name\": \"iPhone 12\",\n" +
                            "  \"serialNumber\": \"SM1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"6.1 дюймов\",\n" +
                            "  \"price\": 999.99,\n" +
                            "  \"memory\": \"128 GB\",\n" +
                            "  \"camerasCount\": 2,\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @PostMapping
    public SmartphoneModel createSmartphoneModel(@RequestBody SmartphoneModel smartphoneModel) {
        return smartphoneModelService.createSmartphoneModel(smartphoneModel);
    }

    @Operation(summary = "Удалить модель смартфона по ID", description = "Удаляет модель смартфона по ID")
    @ApiResponse(responseCode = "204", description = "Модель смартфона удалена")
    @DeleteMapping(BaseRoutes.BY_ID)
    public void deleteSmartphoneModel(@PathVariable Long id) {
        smartphoneModelService.deleteSmartphoneModel(id);
    }

    @Operation(summary = "Поиск модели смартфона по наименованию", description = "Ищет модель смартфона по наименованию")
    @ApiResponse(responseCode = "200", description = "Список найденных моделей смартфонов",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = SmartphoneModel.class),
                    examples = @ExampleObject(name = "Пример поиска модели смартфона", value = "[{\n" +
                            "  \"name\": \"iPhone 12\",\n" +
                            "  \"serialNumber\": \"SM1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"6.1 дюймов\",\n" +
                            "  \"price\": 999.99,\n" +
                            "  \"memory\": \"128 GB\",\n" +
                            "  \"camerasCount\": 2,\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.SEARCH)
    public List<SmartphoneModel> searchSmartphoneModelByName(@RequestParam String name) {
        return smartphoneModelService.searchSmartphoneModelByName(name);
    }

    @Operation(summary = "Фильтрация моделей смартфонов", description = "Фильтрует модели смартфонов по различным критериям")
    @ApiResponse(responseCode = "200", description = "Список отфильтрованных моделей смартфонов",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = SmartphoneModel.class),
                    examples = @ExampleObject(name = "Пример фильтрации моделей смартфонов", value = "[{\n" +
                            "  \"name\": \"iPhone 12\",\n" +
                            "  \"serialNumber\": \"SM1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"6.1 дюймов\",\n" +
                            "  \"price\": 999.99,\n" +
                            "  \"memory\": \"128 GB\",\n" +
                            "  \"camerasCount\": 2,\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.FILTER)
    public List<SmartphoneModel> filterSmartphoneModels(@RequestParam(required = false) String color,
                                                        @RequestParam(required = false) Double priceMin,
                                                        @RequestParam(required = false) Double priceMax) {
        if (color != null) {
            return smartphoneModelService.filterSmartphoneModelsByColor(color);
        } else if (priceMin != null && priceMax != null) {
            return smartphoneModelService.filterSmartphoneModelsByPriceRange(priceMin, priceMax);
        } else {
            return smartphoneModelService.getAllSmartphoneModels();
        }
    }
}