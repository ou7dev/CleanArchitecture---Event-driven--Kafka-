package com.example.demo.application.usecase;

import java.util.List;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.repository.StudentRepository;

public class FindUserUseCase {

    private final StudentRepository studentRepository;

    public FindUserUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(String uuid) {
        return studentRepository.findByUuid(uuid);
    }

    public List<Student> execute() {
        return studentRepository.findAll();
    }
}
