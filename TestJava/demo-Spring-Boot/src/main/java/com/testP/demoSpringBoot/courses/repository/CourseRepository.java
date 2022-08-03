package com.testP.demoSpringBoot.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testP.demoSpringBoot.courses.bean.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{
}
