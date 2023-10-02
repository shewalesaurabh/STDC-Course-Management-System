package com.cdac.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
