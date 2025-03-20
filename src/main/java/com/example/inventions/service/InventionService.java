package com.example.inventions.service;

import com.example.inventions.model.Invention;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Сервис для управления изобретениями.
 */
@Service
public class InventionService {

  private final List<Invention> inventions = new ArrayList<>();

  /**
   * Конструктор сервиса, который добавляет тестовые данные.
   */
  public InventionService() {
    // Добавляем тестовые данные
    inventions.add(new Invention(1L, "Лампочка", "Электрическая лампочка, изобретённая Томасом Эдисоном."));
    inventions.add(new Invention(2L, "Телефон", "Устройство для передачи голоса, изобретённое Александром Беллом."));
    inventions.add(new Invention(3L, "Интернет", "Система глобальной связи, изобретённая в 20 веке."));
  }

  /**
   * Получение всех изобретений.
   *
   * @return список всех изобретений
   */
  public List<Invention> getAllInventions() {
    return inventions;
  }

  /**
   * Поиск изобретения по ID.
   *
   * @param id идентификатор изобретения
   * @return найденное изобретение или null, если не найдено
   */
  public Invention getInventionById(Long id) {
    return inventions.stream().filter(invention -> invention.getId().equals(id)).findFirst().orElse(null);
  }

}