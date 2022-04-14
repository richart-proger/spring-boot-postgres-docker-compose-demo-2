package com.example.postgres.springbootpostgresdockerdemo2.web;

import com.example.postgres.springbootpostgresdockerdemo2.model.Student;
import com.example.postgres.springbootpostgresdockerdemo2.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "list")
    public List<Student> list() {
        return studentService.list();
    }

    @PostMapping(path = "item")
    public void add(@RequestBody Student student) {
        studentService.add(student);
    }

    @DeleteMapping(path = "item/{studentId}")
    public void delete(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }

    @PutMapping(path = "item")
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }
}
