package org.example.flywayexistingdbdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.example.flywayexistingdbdemo.entities.Test;
import org.example.flywayexistingdbdemo.repositories.TestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {
    private final TestRepository testRepository;

    @GetMapping
    public List<Test> test() {
        return testRepository.findAll();
    }
}
