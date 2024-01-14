package org.example.flywayexistingdbdemo.repositories;

import org.example.flywayexistingdbdemo.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}