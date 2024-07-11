package com.example.techregistry.controller;


import com.example.techregistry.configuration.BaseRoutes;
import com.example.techregistry.model.VacuumModel;
import com.example.techregistry.service.VacuumModelService;
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
@RequestMapping(BaseRoutes.VACUUM)
public class VacuumModelController {

    private final VacuumModelService vacuumModelService;


    @Operation(summary = "Получить все модели пылесосов", description = "Возвращает список всех моделей пылесосов")
    @ApiResponse(responseCode = "200", description = "Список моделей пылесосов",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = VacuumModel.class),
                    examples = @ExampleObject(name = "Пример модели пылесоса", value = "{\n" +
                            "  \"name\": \"Dyson V11\",\n" +
                            "  \"serialNumber\": \"VC1234567890\",\n" +
                            "  \"color\": \"Серый\",\n" +
                            "  \"size\": \"30 см\",\n" +
                            "  \"price\": 599.99,\n" +
                            "  \"dustContainerVolume\": \"0.5 литра\",\n" +
                            "  \"modesCount\": 3,\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @GetMapping
    public List<VacuumModel> getAllVacuumModels() {
        return vacuumModelService.getAllVacuumModels();
    }

    @Operation(summary = "Получить модель пылесоса по ID", description = "Возвращает модель пылесоса по ID")
    @ApiResponse(responseCode = "200", description = "Модель пылесоса найдена",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = VacuumModel.class),
                    examples = @ExampleObject(name = "Пример модели пылесоса", value = "{\n" +
                            "  \"name\": \"Dyson V11\",\n" +
                            "  \"serialNumber\": \"VC1234567890\",\n" +
                            "  \"color\": \"Серый\",\n" +
                            "  \"size\": \"30 см\",\n" +
                            "  \"price\": 599.99,\n" +
                            "  \"dustContainerVolume\": \"0.5 литра\",\n" +
                            "  \"modesCount\": 3,\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @GetMapping(BaseRoutes.BY_ID)
    public VacuumModel getVacuumModelById(@PathVariable Long id) {
        return vacuumModelService.getVacuumModelById(id);
    }


    @Operation(summary = "Создать новую модель пылесоса", description = "Создает новую модель пылесоса и возвращает её")
    @ApiResponse(responseCode = "201", description = "Модель пылесоса создана",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = VacuumModel.class),
                    examples = @ExampleObject(name = "Пример создания модели пылесоса", value = "{\n" +
                            "  \"name\": \"Dyson V11\",\n" +
                            "  \"serialNumber\": \"VC1234567890\",\n" +
                            "  \"color\": \"Серый\",\n" +
                            "  \"size\": \"30 см\",\n" +
                            "  \"price\": 599.99,\n" +
                            "  \"dustContainerVolume\": \"0.5 литра\",\n" +
                            "  \"modesCount\": 3,\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @PostMapping
    public VacuumModel createVacuumModel(@RequestBody VacuumModel vacuumModel) {
        return vacuumModelService.createVacuumModel(vacuumModel);
    }

    @Operation(summary = "Удалить модель пылесоса по ID", description = "Удаляет модель пылесоса по ID")
    @ApiResponse(responseCode = "204", description = "Модель пылесоса удалена")
    @DeleteMapping(BaseRoutes.BY_ID)
    public void deleteVacuumModel(@PathVariable Long id) {
        vacuumModelService.deleteVacuumModel(id);
    }


    @Operation(summary = "Поиск модели пылесоса по наименованию", description = "Ищет модель пылесоса по наименованию")
    @ApiResponse(responseCode = "200", description = "Список найденных моделей пылесосов",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = VacuumModel.class),
                    examples = @ExampleObject(name = "Пример поиска модели пылесоса", value = "[{\n" +
                            "  \"name\": \"Dyson V11\",\n" +
                            "  \"serialNumber\": \"VC1234567890\",\n" +
                            "  \"color\": \"Серый\",\n" +
                            "  \"size\": \"30 см\",\n" +
                            "  \"price\": 599.99,\n" +
                            "  \"dustContainerVolume\": \"0.5 литра\",\n" +
                            "  \"modesCount\": 3,\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.SEARCH)
    public List<VacuumModel> searchVacuumModelByName(@RequestParam String name) {
        return vacuumModelService.searchVacuumModelByName(name);
    }


    @Operation(summary = "Фильтрация моделей пылесосов", description = "Фильтрует модели пылесосов по различным критериям")
    @ApiResponse(responseCode = "200", description = "Список отфильтрованных моделей пылесосов",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = VacuumModel.class),
                    examples = @ExampleObject(name = "Пример фильтрации моделей пылесосов", value = "[{\n" +
                            "  \"name\": \"Dyson V11\",\n" +
                            "  \"serialNumber\": \"VC1234567890\",\n" +
                            "  \"color\": \"Серый\",\n" +
                            "  \"size\": \"30 см\",\n" +
                            "  \"price\": 599.99,\n" +
                            "  \"dustContainerVolume\": \"0.5 литра\",\n" +
                            "  \"modesCount\": 3,\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.FILTER)
    public List<VacuumModel> filterVacuumModels(@RequestParam(required = false) String color,
                                                @RequestParam(required = false) Double priceMin,
                                                @RequestParam(required = false) Double priceMax) {
        if (color != null) {
            return vacuumModelService.filterVacuumModelsByColor(color);
        } else if (priceMin != null && priceMax != null) {
            return vacuumModelService.filterVacuumModelsByPriceRange(priceMin, priceMax);
        } else {
            return vacuumModelService.getAllVacuumModels();
        }
    }
}
