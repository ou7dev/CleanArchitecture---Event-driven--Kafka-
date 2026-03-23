package com.example.demo.application.usecase;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.repository.StudentEventPublisher;
import com.example.demo.domain.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentEventPublisher studentEventPublisher;

    @InjectMocks
    private CreateUserUseCase createUserUseCase;

    @Test
    void execute_ShouldSaveStudentAndPublishEvent() {
        // Arrange
        String name = "John Doe";
        String email = "john@example.com";
        String password = "password123";
        String role = "ROLE_USER";

        Student mockStudent = new Student("uuid-1234", name, email, password, role);
        when(studentRepository.save(name, email, password, role)).thenReturn(mockStudent);

        // Act
        Student result = createUserUseCase.execute(name, email, password, role);

        // Assert
        assertNotNull(result);
        assertEquals("uuid-1234", result.getUuid());
        assertEquals(name, result.getName());
        assertEquals(email, result.getEmail());

        verify(studentRepository, times(1)).save(name, email, password, role);
        verify(studentEventPublisher, times(1)).publish(mockStudent);
    }
}
