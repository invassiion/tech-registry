package com.example.techregistry.controller;

import com.example.techregistry.configuration.BaseRoutes;
import com.example.techregistry.model.FridgeModel;
import com.example.techregistry.service.FridgeModelService;
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
@RequestMapping(BaseRoutes.FRIDGE)
public class FridgeModelController {
    private final FridgeModelService fridgeModelService;



    @Operation(summary = "Получить все модели холодильников", description = "Возвращает список всех моделей холодильников")
    @ApiResponse(responseCode = "200", description = "Список моделей холодильников",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = FridgeModel.class),
                    examples = @ExampleObject(name = "Пример модели холодильника", value = "{\n" +
                            "  \"name\": \"LG Fridge\",\n" +
                            "  \"serialNumber\": \"FR1234567890\",\n" +
                            "  \"color\": \"Белый\",\n" +
                            "  \"size\": \"200 см\",\n" +
                            "  \"price\": 899.99,\n" +
                            "  \"doorsCount\": 2,\n" +
                            "  \"compressorType\": \"Инверторный\",\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @GetMapping
    public List<FridgeModel> getAllFridgeModels() {
        return fridgeModelService.getAllFridgeModels();
    }

    @Operation(summary = "Получить модель холодильника по ID", description = "Возвращает модель холодильника по ID")
    @ApiResponse(responseCode = "200", description = "Модель холодильника найдена",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = FridgeModel.class),
                    examples = @ExampleObject(name = "Пример модели холодильника", value = "{\n" +
                            "  \"name\": \"LG Fridge\",\n" +
                            "  \"serialNumber\": \"FR1234567890\",\n" +
                            "  \"color\": \"Белый\",\n" +
                            "  \"size\": \"200 см\",\n" +
                            "  \"price\": 899.99,\n" +
                            "  \"doorsCount\": 2,\n" +
                            "  \"compressorType\": \"Инверторный\",\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @GetMapping(BaseRoutes.BY_ID)
    public FridgeModel getFridgeModelById(@PathVariable Long id) {
        return fridgeModelService.getFridgeModelById(id);
    }

    @Operation(summary = "Создать новую модель холодильника", description = "Создает новую модель холодильника и возвращает её")
    @ApiResponse(responseCode = "201", description = "Модель холодильника создана",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = FridgeModel.class),
                    examples = @ExampleObject(name = "Пример создания модели холодильника", value = "{\n" +
                            "  \"name\": \"LG Fridge\",\n" +
                            "  \"serialNumber\": \"FR1234567890\",\n" +
                            "  \"color\": \"Белый\",\n" +
                            "  \"size\": \"200 см\",\n" +
                            "  \"price\": 899.99,\n" +
                            "  \"doorsCount\": 2,\n" +
                            "  \"compressorType\": \"Инверторный\",\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @PostMapping
    public FridgeModel createFridgeModel(@RequestBody FridgeModel fridgeModel) {
        return fridgeModelService.createFridgeModel(fridgeModel);
    }

    @Operation(summary = "Удалить модель холодильника по ID", description = "Удаляет модель холодильника по ID")
    @ApiResponse(responseCode = "204", description = "Модель холодильника удалена")
    @DeleteMapping(BaseRoutes.BY_ID)
    public void deleteFridgeModel(@PathVariable Long id) {
        fridgeModelService.deleteFridgeModel(id);
    }

    @Operation(summary = "Поиск модели холодильника по наименованию", description = "Ищет модель холодильника по наименованию")
    @ApiResponse(responseCode = "200", description = "Список найденных моделей холодильников",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = FridgeModel.class),
                    examples = @ExampleObject(name = "Пример поиска модели холодильника", value = "[{\n" +
                            "  \"name\": \"LG Fridge\",\n" +
                            "  \"serialNumber\": \"FR1234567890\",\n" +
                            "  \"color\": \"Белый\",\n" +
                            "  \"size\": \"200 см\",\n" +
                            "  \"price\": 899.99,\n" +
                            "  \"doorsCount\": 2,\n" +
                            "  \"compressorType\": \"Инверторный\",\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.SEARCH)
    public List<FridgeModel> searchFridgeModelByName(@RequestParam String name) {
        return fridgeModelService.searchFridgeModelByName(name);
    }

    @Operation(summary = "Фильтрация моделей холодильников", description = "Фильтрует модели холодильников по различным критериям")
    @ApiResponse(responseCode = "200", description = "Список отфильтрованных моделей холодильников",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = FridgeModel.class),
                    examples = @ExampleObject(name = "Пример фильтрации моделей холодильников", value = "[{\n" +
                            "  \"name\": \"LG Fridge\",\n" +
                            "  \"serialNumber\": \"FR1234567890\",\n" +
                            "  \"color\": \"Белый\",\n" +
                            "  \"size\": \"200 см\",\n" +
                            "  \"price\": 899.99,\n" +
                            "  \"doorsCount\": 2,\n" +
                            "  \"compressorType\": \"Инверторный\",\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.FILTER)
    public List<FridgeModel> filterFridgeModels(@RequestParam(required = false) String color,
                                                @RequestParam(required = false) Double priceMin,
                                                @RequestParam(required = false) Double priceMax) {
        if (color != null) {
            return fridgeModelService.filterFridgeModelsByColor(color);
        } else if (priceMin != null && priceMax != null) {
            return fridgeModelService.filterFridgeModelsByPriceRange(priceMin, priceMax);
        } else {
            return fridgeModelService.getAllFridgeModels();
        }
    }
}