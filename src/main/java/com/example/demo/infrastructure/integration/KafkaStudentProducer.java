package com.example.demo.infrastructure.integration;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.domain.models.Student;
import com.example.demo.domain.repository.StudentEventPublisher;
import com.example.demo.infrastructure.integration.events.StudentEvent;

@Component
public class KafkaStudentProducer implements StudentEventPublisher {

    private final KafkaTemplate<String, StudentEvent> kafkaTemplate;

    public KafkaStudentProducer(KafkaTemplate<String, StudentEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(Student student) {
        StudentEvent studentEvent = new StudentEvent(student.getUuid(), student.getName(), student.getEmail(),
                student.getPassword(), student.getRole());

        kafkaTemplate.send("student-topic", studentEvent);
    }

}