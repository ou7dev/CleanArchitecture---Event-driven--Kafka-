package com.example.demo.application.usecase;

import com.example.demo.domain.repository.StudentRepository;

public class CreateUserUseCase {

    private final StudentRepository studentRepository;

    public CreateUserUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void execute(String name, String email, String password, String role) {
        studentRepository.save(name, email, password, role);
    }
}
