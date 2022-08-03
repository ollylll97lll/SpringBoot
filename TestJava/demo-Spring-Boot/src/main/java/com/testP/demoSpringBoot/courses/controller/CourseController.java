package com.testP.demoSpringBoot.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testP.demoSpringBoot.courses.bean.Course;
import com.testP.demoSpringBoot.courses.repository.CourseRepository;

@RestController
public class CourseController {
    @Autowired
    CourseRepository repository;

    // http://localhost:8080/courses
    @GetMapping(value = "/courses")
    public List<Course> getAllCourses() {
        return repository.findAll();
        // return Arrays.asList(new Course(1, "Learn Microservices", "in 28 minutes"));
    }

    // http://localhost:8080/courses/1
    @GetMapping(value = "/courses/{id}")
    public Course getOneCourse(@PathVariable long id) {
        try {
            Optional<Course> course = repository.findById(id);
            return course.get();
        } catch (Exception e) {
            throw new RuntimeException("Course not found with id " + id);
        }
        // return new Course(2, "Learn Microservices 2", "in 28 minutes");
    }

    /**
     * POST
     */
    //

    // http://localhost:8080/courses
    @PostMapping(value = "/courses")
    public void creatCourse(@RequestBody Course course) {
        // try {
        //     repository.save(course);
        // } catch (Exception e) {
        //     throw new RuntimeException("Course cannot create with data ");
        // }

            repository.save(course);

    }

    /**
     * PATCH
     * @param course
     */

    // http://localhost:8080/course
    @PutMapping(value = "/courses/{id}")
    public void updateCourse(@RequestBody Course course,@PathVariable long id) {
        try {
            repository.save(course);
        } catch (Exception e) {
            //TODO: handle exception
            throw new Error(e);
        }
    }

     /**
     * DELETE
     * @param course
     */

    // http://localhost:8080/course
    @DeleteMapping(value = "/courses/{id}")
    public void updateCourse(@PathVariable long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            //TODO: handle exception
            throw new Error(e);
        }
    }

}
