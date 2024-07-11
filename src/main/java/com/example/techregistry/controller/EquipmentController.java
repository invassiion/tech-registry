package com.example.techregistry.controller;

import com.example.techregistry.configuration.BaseRoutes;
import com.example.techregistry.model.Equipment;
import com.example.techregistry.service.EquipmentService;
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
@RequestMapping(BaseRoutes.EQUIPMENT)
public class EquipmentController {

    private final EquipmentService equipmentService;


    @Operation(summary = "Получить все оборудование", description = "Возвращает список всего оборудования")
    @ApiResponse(responseCode = "200", description = "Список оборудования",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Equipment.class),
                    examples = @ExampleObject(name = "Пример оборудования", value = "{\n" +
                            "  \"id\": 1,\n" +
                            "  \"name\": \"Стиральная машина\",\n" +
                            "  \"description\": \"Модель X1\",\n" +
                            "  \"serialNumber\": \"EQ123456\",\n" +
                            "  \"price\": 499.99,\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @Operation(summary = "Получить оборудование по ID", description = "Возвращает оборудование по ID")
    @ApiResponse(responseCode = "200", description = "Оборудование найдено",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Equipment.class),
                    examples = @ExampleObject(name = "Пример оборудования", value = "{\n" +
                            "  \"id\": 1,\n" +
                            "  \"name\": \"Стиральная машина\",\n" +
                            "  \"description\": \"Модель X1\",\n" +
                            "  \"serialNumber\": \"EQ123456\",\n" +
                            "  \"price\": 499.99,\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @GetMapping(BaseRoutes.BY_ID)
    public Equipment getEquipmentById(@PathVariable Long id) {
        return equipmentService.getEquipmentById(id);
    }

    @Operation(summary = "Создать новое оборудование", description = "Создает новое оборудование и возвращает его")
    @ApiResponse(responseCode = "201", description = "Оборудование создано",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Equipment.class),
                    examples = @ExampleObject(name = "Пример создания оборудования", value = "{\n" +
                            "  \"id\": 1,\n" +
                            "  \"name\": \"Стиральная машина\",\n" +
                            "  \"description\": \"Модель X1\",\n" +
                            "  \"serialNumber\": \"EQ123456\",\n" +
                            "  \"price\": 499.99,\n" +
                            "  \"inStock\": true\n" +
                            "}")))
    @PostMapping
    public Equipment createEquipment(@RequestBody Equipment equipment) {
        return equipmentService.createEquipment(equipment);
    }

    @Operation(summary = "Удалить оборудование по ID", description = "Удаляет оборудование по ID")
    @ApiResponse(responseCode = "204", description = "Оборудование удалено")
    @DeleteMapping(BaseRoutes.BY_ID)
    public void deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
    }

    @Operation(summary = "Поиск оборудования по наименованию", description = "Ищет оборудование по наименованию")
    @ApiResponse(responseCode = "200", description = "Список найденного оборудования",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Equipment.class),
                    examples = @ExampleObject(name = "Пример поиска оборудования", value = "[{\n" +
                            "  \"id\": 1,\n" +
                            "  \"name\": \"Стиральная машина\",\n" +
                            "  \"description\": \"Модель X1\",\n" +
                            "  \"serialNumber\": \"EQ123456\",\n" +
                            "  \"price\": 499.99,\n" +
                            "  \"inStock\": true\n" +
                            "}]")))
    @GetMapping(BaseRoutes.SEARCH)
    public List<Equipment> searchEquipmentByName(@RequestParam String name) {
        return equipmentService.searchEquipmentByName(name);
    }
}
