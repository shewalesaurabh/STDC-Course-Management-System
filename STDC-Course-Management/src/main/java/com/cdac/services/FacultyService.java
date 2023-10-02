package com.cdac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.models.Faculty;
import com.cdac.repos.FacultyRepository;

@Service
public class FacultyService {

	@Autowired private FacultyRepository repo;
	
	public void save(Faculty ins) {
		if(ins.getId()==0) {
			int id=(int)repo.count()+10001;
			ins.setId(id);
		}
		repo.save(ins);
	}
	
	public List<Faculty> listFeedbackFaculty(int rollno){
		return repo.findFacultyForFeedback(rollno);
	}
	
	public Faculty findById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Faculty> listAll(){
		return repo.findAll();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
