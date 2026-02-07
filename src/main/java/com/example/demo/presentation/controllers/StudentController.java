package com.example.demo.presentation.controllers;

import java.util.List;

import com.example.demo.application.usecase.CreateUserUseCase;
import com.example.demo.application.usecase.FindUserUseCase;
import com.example.demo.domain.models.Student;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    private final FindUserUseCase findUserUseCase;
    private final CreateUserUseCase createUserUseCase;

    public StudentController(FindUserUseCase findUserUseCase, CreateUserUseCase createUserUseCase) {
        this.findUserUseCase = findUserUseCase;
        this.createUserUseCase = createUserUseCase;
    }

    @GetMapping("/student/{uuid}")
    public Student getStudent(@PathVariable String uuid) {
        return findUserUseCase.execute(uuid);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return findUserUseCase.execute();
    }

    @PostMapping("/create-student")
    public void saveStudent(@RequestBody Student student) {

        String name = student.getName();
        String email = student.getEmail();
        String password = student.getPassword();
        String role = student.getRole();

        createUserUseCase.execute(name, email, password, role);
    }

}
