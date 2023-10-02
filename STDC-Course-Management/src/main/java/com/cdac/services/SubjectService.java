package com.cdac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.SubjectDTO;
import com.cdac.models.Course;
import com.cdac.models.Subject;
import com.cdac.repos.SubjectRepository;

@Service
public class SubjectService {

	@Autowired private SubjectRepository repo;
	@Autowired private CourseService csrv;
	
	public void saveSubject(SubjectDTO dto) {
		Subject subject=new Subject();
		subject.setName(dto.getSname());
		subject.setCourse(csrv.findById(dto.getCid()));
		repo.save(subject);
	}
	
	public List<Subject> listAll(){
		return repo.findAll();
	}
	
	public Subject findById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public void deleteSubject(int id) {
		repo.deleteById(id);
	}
	
	public List<Subject> courseSubjects(int cid){
		return repo.findByCourseCid(cid);
	}
}
