package com.example.demo.domain.repository;

import java.util.List;

import com.example.demo.domain.models.Student;

public interface StudentRepository {

    Student save(String name, String email, String password, String role);

    Student findByUuid(String uuid);

    List<Student> findAll();

}
