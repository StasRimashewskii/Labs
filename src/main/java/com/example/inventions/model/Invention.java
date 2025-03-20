package com.example.inventions.model;

/**
 * Класс, представляющий изобретение.
 */
public class Invention {
  private Long id;
  private String name;
  private String description;

  /**
   * Конструктор для создания нового изобретения.
   *
   * @param id уникальный идентификатор изобретения
   * @param name название изобретения
   * @param description описание изобретения
   */
  public Invention(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  /**
   * Получает уникальный идентификатор изобретения.
   *
   * @return уникальный идентификатор
   */
  public Long getId() {
    return id;
  }

  /**
   * Устанавливает уникальный идентификатор изобретения.
   *
   * @param id уникальный идентификатор
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Получает название изобретения.
   *
   * @return название изобретения
   */
  public String getName() {
    return name;
  }

  /**
     * Устанавливает название изобретения.
     *
     * @param name название изобретения
     */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Получает описание изобретения.
   *
   * @return описание изобретения
   */
  public String getDescription() {
    return description;
  }

  /**
   * Устанавливает описание изобретения.
   *
   * @param description описание изобретения
   */
  public void setDescription(String description) {
    this.description = description;
  }
}
