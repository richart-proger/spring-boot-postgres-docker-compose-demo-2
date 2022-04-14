package com.example.postgres.springbootpostgresdockerdemo2.service;

import com.example.postgres.springbootpostgresdockerdemo2.model.Student;
import com.example.postgres.springbootpostgresdockerdemo2.repository.StudentRepository;
import com.example.postgres.springbootpostgresdockerdemo2.response.ForbiddenException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list() {
        return studentRepository.findAll();
    }

    public void add(Student student) {
        if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new ForbiddenException("Email is busy");
        }
        studentRepository.save(student);
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void update(Student student) {
        Student updated = studentRepository.findById(student.getId()).orElse(null);
        if (updated != null) {
            if (!student.getName().isEmpty()) {
                updated.setName(student.getName());
            }
            if (student.getDob() != null) {
                updated.setDob(student.getDob());
            }
            studentRepository.save(updated);
        }
    }
}
