package com.springboot.mark;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "mark"),
                new Course(2, "Learn DevOps", "mark"),
                new Course(3, "Learn Azure", "mark"),
                new Course(4, "Learn GCP", "mark")
        );
    }
}
