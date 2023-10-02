package com.cdac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.models.Feedback;
import com.cdac.repos.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired private FeedbackRepository repo;
	
	public void save(Feedback fb) {
		repo.save(fb);
	}
	
	public List<Feedback> listAll(){
		return repo.findAll();
	}
	
	public List<Feedback> studentFeedbacks(int rollno){
		return repo.findByStudentRollno(rollno);
	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
}
