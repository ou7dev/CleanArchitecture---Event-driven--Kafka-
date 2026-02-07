package com.example.demo.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.infrastructure.persistence.entity.StudentEntity;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByUuid(String uuid);
}
