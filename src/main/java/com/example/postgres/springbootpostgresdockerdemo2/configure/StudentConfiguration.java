package com.example.postgres.springbootpostgresdockerdemo2.configure;

import com.example.postgres.springbootpostgresdockerdemo2.model.Student;
import com.example.postgres.springbootpostgresdockerdemo2.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class StudentConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> studentRepository.saveAll(Arrays.asList(
                new Student("Alex", "alex@gmail.com", LocalDate.now().minusDays(25).minusYears(18)),
                new Student("Tom", "tom@gmail.com", LocalDate.now().minusDays(27).minusYears(25)),
                new Student("John", "john@gmail.com", LocalDate.now().minusDays(3).minusYears(7))
        ));
    }
}