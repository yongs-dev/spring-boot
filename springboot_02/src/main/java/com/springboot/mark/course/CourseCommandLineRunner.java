package com.springboot.mark.course;

import com.springboot.mark.course.jpa.CourseJpaRepository;
import com.springboot.mark.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Mark", "Ethan"));
        repository.save(new Course(2, "Mark2", "Ethan"));
        repository.save(new Course(3, "Mark3", "Ethan"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findByAuthor("Ethan"));
        System.out.println(repository.findByName("Mark2"));
    }
}
