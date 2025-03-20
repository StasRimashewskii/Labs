package com.example.inventions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Основной класс приложения, запускающий Spring Boot.
 */
@SpringBootApplication
public class InventionsApplication {
  /**
   * Точка входа в приложение.
   *
   * @param args аргументы командной строки
   */
  public static void main(String[] args) {
    SpringApplication.run(InventionsApplication.class, args);
  }
}