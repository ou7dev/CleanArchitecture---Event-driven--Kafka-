package com.example.demo.infrastructure.persistence.adapter;

import java.util.List;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.repository.StudentRepository;
import com.example.demo.infrastructure.persistence.entity.StudentEntity;
import com.example.demo.infrastructure.persistence.repository.StudentJpaRepository;

public class StudentRepositoryAdapter implements StudentRepository {

    private final StudentJpaRepository studentJpaRepository;

    public StudentRepositoryAdapter(StudentJpaRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public Student save(String name, String email, String password, String role) {
        StudentEntity studentEntity = new StudentEntity(name, email, password, role);
        studentEntity.setUuid(java.util.UUID.randomUUID().toString());

        StudentEntity savedEntity = studentJpaRepository.save(studentEntity);
        return toDomain(savedEntity);
    }

    @Override
    public Student findByUuid(String uuid) {
        StudentEntity entity = studentJpaRepository.findByUuid(uuid);
        return entity != null ? toDomain(entity) : null;
    }

    @Override
    public List<Student> findAll() {
        return studentJpaRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    private Student toDomain(StudentEntity entity) {
        return new Student(
                entity.getUuid(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole());
    }

}
