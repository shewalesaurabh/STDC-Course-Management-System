package com.cdac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.models.Course;
import com.cdac.repos.CourseRepository;

@Service
public class CourseService {

	@Autowired private CourseRepository repo;
	
	public void saveCourse(Course course) {
		repo.save(course);
	}
	
	public List<Course> listAll(){
		return repo.findAll();
	}
	
	public Course findById(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteCourse(int id) {
		repo.deleteById(id);
	}
}
