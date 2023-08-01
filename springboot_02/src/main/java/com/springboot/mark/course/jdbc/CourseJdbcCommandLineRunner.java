package com.springboot.mark.course.jdbc;

import com.springboot.mark.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository repository;

    @Autowired
    public CourseJdbcCommandLineRunner(CourseJdbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Mark", "Ethan"));
        repository.insert(new Course(2, "Mark2", "Ethan"));
        repository.insert(new Course(3, "Mark3", "Ethan"));

        repository.deleteById(1);

        System.out.println(repository.findById(2).toString());
        System.out.println(repository.findById(3).toString());
    }
}
