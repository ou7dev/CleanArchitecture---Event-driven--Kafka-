package com.example.demo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.application.usecase.CreateUserUseCase;
import com.example.demo.application.usecase.FindUserUseCase;
import com.example.demo.domain.repository.StudentRepository;
import com.example.demo.infrastructure.persistence.adapter.StudentRepositoryAdapter;
import com.example.demo.infrastructure.persistence.repository.StudentJpaRepository;

@Configuration
public class AppSettings {

    @Bean
    public StudentRepository studentRepository(StudentJpaRepository studentJpaRepository) {
        return new StudentRepositoryAdapter(studentJpaRepository);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(StudentRepository studentRepository) {
        return new CreateUserUseCase(studentRepository);
    }

    @Bean
    public FindUserUseCase findUserUseCase(StudentRepository studentRepository) {
        return new FindUserUseCase(studentRepository);
    }

}
