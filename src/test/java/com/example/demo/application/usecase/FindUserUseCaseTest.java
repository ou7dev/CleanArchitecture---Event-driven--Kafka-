package com.example.demo.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class FindUserUseCaseTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private FindUserUseCase findUserUseCase;

    @Test
    void execute_ShouldReturnStudent_WhenUuidIsValid() {
        String uuid = "uuid-1234";
        Student student = new Student(uuid, "John Doe", "[EMAIL_ADDRESS]", "password123", "ROLE_USER");
        when(studentRepository.findByUuid(uuid)).thenReturn(student);

        Student result = findUserUseCase.execute(uuid);

        assertNotNull(result);
        assertEquals(uuid, result.getUuid());
        assertEquals("John Doe", result.getName());
        assertEquals("[EMAIL_ADDRESS]", result.getEmail());
        verify(studentRepository, times(1)).findByUuid(uuid);
    }

    @Test
    void execute_ShouldReturnAllStudents_WhenNoUuidIsProvided() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("uuid-1234", "John Doe", "[EMAIL_ADDRESS]", "password123", "ROLE_USER"));
        students.add(new Student("uuid-5678", "Jane Doe", "[EMAIL_ADDRESS]", "password123", "ROLE_USER"));
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = findUserUseCase.execute();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void execute_ShouldReturnEmptyList_WhenNoStudentsAreFound() {
        List<Student> students = new ArrayList<>();
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = findUserUseCase.execute();

        assertNotNull(result);
        assertEquals(0, result.size());
        verify(studentRepository, times(1)).findAll();
    }

}
