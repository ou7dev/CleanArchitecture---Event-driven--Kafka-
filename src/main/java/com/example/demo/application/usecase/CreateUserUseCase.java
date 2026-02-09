package com.example.demo.application.usecase;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.repository.StudentEventPublisher;
import com.example.demo.domain.repository.StudentRepository;

public class CreateUserUseCase {

    private final StudentRepository studentRepository;
    private final StudentEventPublisher studentEventPublisher;

    public CreateUserUseCase(StudentRepository studentRepository, StudentEventPublisher studentEventPublisher) {
        this.studentRepository = studentRepository;
        this.studentEventPublisher = studentEventPublisher;
    }

    public Student execute(String name, String email, String password, String role) {
        Student student = studentRepository.save(name, email, password, role);
        studentEventPublisher.publish(student);
        return student;
    }
}
