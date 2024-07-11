package com.example.techregistry.controller;


import com.example.techregistry.configuration.BaseRoutes;
import com.example.techregistry.model.TvModel;
import com.example.techregistry.service.TvModelService;
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
@RequestMapping(BaseRoutes.TVMODEL)
public class TvModelController {


    private final TvModelService tvModelService;

    @Operation(summary = "Получить все модели телевизоров", description = "Возвращает список всех моделей телевизоров")
    @ApiResponse(responseCode = "200", description = "Список моделей телевизоров",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TvModel.class),
                            examples = @ExampleObject(name = "Пример модели телевизора", value = "{\n" +
                                    "  \"name\": \"Samsung Smart TV\",\n" +
                                    "  \"serialNumber\": \"TV1234567890\",\n" +
                                    "  \"color\": \"Черный\",\n" +
                                    "  \"size\": \"55 дюймов\",\n" +
                                    "  \"price\": 499.99,\n" +
                                    "  \"category\": \"Смарт ТВ\",\n" +
                                    "  \"technology\": \"LED\",\n" +
                                    "  \"inStock\": true\n" +
                                    "}")))
    @GetMapping
    public List<TvModel> getAllTvModels() {
        return tvModelService.getAllTvModels();
    }


    @Operation(summary = "Получить модель телевизора по ID", description = "Возвращает модель телевизора по ID")
    @ApiResponse(responseCode = "200", description = "Модель телевизора найдена",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TvModel.class),
                    examples = @ExampleObject(name = "Пример модели телевизора", value = "{\n" +
                            "  \"name\": \"Samsung Smart TV\",\n" +
                            "  \"serialNumber\": \"TV1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"55 дюймов\",\n" +
                            "  \"price\": 499.99,\n" +
                            "  \"category\": \"Смарт ТВ\",\n" +
                            "  \"technology\": \"LED\",\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @GetMapping(BaseRoutes.BY_ID)
    public TvModel getTvModelById(@PathVariable Long id) {
        return tvModelService.getTvModelById(id);
    }


    @Operation(summary = "Создать новую модель телевизора", description = "Создает новую модель телевизора и возвращает её")
    @ApiResponse(responseCode = "201", description = "Модель телевизора создана",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TvModel.class),
                    examples = @ExampleObject(name = "Пример создания модели телевизора", value = "{\n" +
                            "  \"name\": \"Samsung Smart TV\",\n" +
                            "  \"serialNumber\": \"TV1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"55 дюймов\",\n" +
                            "  \"price\": 499.99,\n" +
                            "  \"category\": \"Смарт ТВ\",\n" +
                            "  \"technology\": \"LED\",\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @PostMapping
    public TvModel createTvModel(@RequestBody TvModel tvModel) {
        return tvModelService.createTvModel(tvModel);
    }

    @Operation(summary = "Удалить модель телевизора по ID", description = "Удаляет модель телевизора по ID")
    @ApiResponse(responseCode = "204", description = "Модель телевизора удалена")
    @DeleteMapping(BaseRoutes.BY_ID)
    public void deleteTvModel(@PathVariable Long id) {
        tvModelService.deleteTvModel(id);
    }

    @Operation(summary = "Поиск модели телевизора по наименованию", description = "Ищет модель телевизора по наименованию")
    @ApiResponse(responseCode = "200", description = "Список найденных моделей телевизоров",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TvModel.class),
                    examples = @ExampleObject(name = "Пример поиска модели телевизора", value = "[{\n" +
                            "  \"name\": \"Samsung Smart TV\",\n" +
                            "  \"serialNumber\": \"TV1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"55 дюймов\",\n" +
                            "  \"price\": 499.99,\n" +
                            "  \"category\": \"Смарт ТВ\",\n" +
                            "  \"technology\": \"LED\",\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.SEARCH)
    public List<TvModel> searchTvModelByName(@RequestParam String name) {
        return tvModelService.searchTvModelByName(name);
    }


    @Operation(summary = "Фильтрация моделей телевизоров", description = "Фильтрует модели телевизоров по различным критериям")
    @ApiResponse(responseCode = "200", description = "Список отфильтрованных моделей телевизоров",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TvModel.class),
                    examples = @ExampleObject(name = "Пример фильтрации моделей телевизоров", value = "[{\n" +
                            "  \"name\": \"Samsung Smart TV\",\n" +
                            "  \"serialNumber\": \"TV1234567890\",\n" +
                            "  \"color\": \"Черный\",\n" +
                            "  \"size\": \"55 дюймов\",\n" +
                            "  \"price\": 499.99,\n" +
                            "  \"category\": \"Смарт ТВ\",\n" +
                            "  \"technology\": \"LED\",\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.FILTER)
    public List<TvModel> filterTvModels(@RequestParam(required = false) String color,
                                        @RequestParam(required = false) Double priceMin,
                                        @RequestParam(required = false) Double priceMax) {
        if (color != null) {
            return tvModelService.filterTvModelsByColor(color);
        } else if (priceMin != null && priceMax != null) {
            return tvModelService.filterTvModelsByPriceRange(priceMin, priceMax);
        } else {
            return tvModelService.getAllTvModels();
        }
    }
}
