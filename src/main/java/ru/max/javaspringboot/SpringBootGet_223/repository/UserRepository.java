package ru.max.javaspringboot.SpringBootGet_223.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.max.javaspringboot.SpringBootGet_223.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
