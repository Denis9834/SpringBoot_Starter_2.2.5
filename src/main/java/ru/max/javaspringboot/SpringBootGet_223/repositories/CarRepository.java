package ru.max.javaspringboot.SpringBootGet_223.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.max.javaspringboot.SpringBootGet_223.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
