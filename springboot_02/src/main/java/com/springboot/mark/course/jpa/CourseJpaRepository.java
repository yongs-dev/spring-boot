package com.springboot.mark.course.jpa;

import com.springboot.mark.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public void deleteById(long id) {
        entityManager.remove(findById(id));
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }
}
