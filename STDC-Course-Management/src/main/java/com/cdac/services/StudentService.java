package com.cdac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.models.Student;
import com.cdac.models.StudentDTO;
import com.cdac.repos.StudentRepository;

@Service
public class StudentService {

	@Autowired private StudentRepository repo;
	@Autowired private CourseService csrv;
	
	public void saveStudent(StudentDTO dto) {
		Student student=Student.toEntity(dto);
		student.setCourse(csrv.findById(dto.getCid()));
		if(dto.getRollno()==0) {
			student.setRollno(generateRollno());
		}
		repo.save(student);
	}
	
	public Student findbyRollno(int rollno){
		return repo.findById(rollno).orElse(null);
	}
	
	public List<Student> listAll(){
		return repo.findAll();
	}
	
	public int generateRollno() {
		return (int)repo.count();
	}
	
	
	public void delete(int id) {
		Student ins=repo.getById(id);
		repo.delete(ins);
	}
}
