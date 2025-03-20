package com.example.inventions.controller;

import com.example.inventions.model.Invention;
import com.example.inventions.service.InventionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Контроллер для работы с изобретениями.
 * Обрабатывает запросы, связанные с получением информации об изобретениях.
 */
@RestController
@RequestMapping("/api/inventions")
public class InventionController {

  private final InventionService inventionService;

  /**
   * Конструктор контроллера.
   *
   * @param inventionService сервис для работы с изобретениями
   */
  public InventionController(InventionService inventionService) {
    this.inventionService = inventionService;
  }

  /**
   * Получить список всех изобретений.
   *
   * @return список изобретений
   */
  @GetMapping
    public ResponseEntity<List<Invention>> getAllInventions() {
    return ResponseEntity.ok(inventionService.getAllInventions());
  }

  /**
   * Получить изобретение по ID.
   *
   * @param id идентификатор изобретения
   * @return найденное изобретение или сообщение об ошибке
   */
  @GetMapping("/{id}")
    public ResponseEntity<Object> getInventionById(@PathVariable Long id) {
    Invention invention = inventionService.getInventionById(id);
    if (invention == null) {
      Map<String, String> errorResponse = new HashMap<>();
      errorResponse.put("error", "404 Not Found!");
      errorResponse.put("message", "Изобретение с ID " + id + " не найдено.");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    return ResponseEntity.ok(invention);
  }

  /**
   * Поиск изобретений по имени.
   *
   * @param name (опционально) часть имени изобретения для поиска
   * @return список найденных изобретений
   */
  @GetMapping("/search")
    public ResponseEntity<List<Invention>> searchInventions(
      @RequestParam(name = "name", required = false) String name) {
    List<Invention> inventions = inventionService.getAllInventions();
    if (name != null && !name.isEmpty()) {
      inventions = inventions.stream().filter(invention -> invention.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }
    return ResponseEntity.ok(inventions);
  }

}