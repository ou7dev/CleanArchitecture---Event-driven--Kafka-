package com.example.demo.domain.repository;

import com.example.demo.domain.models.Student;

public interface StudentEventPublisher {
    public void publish(Student student);
}
