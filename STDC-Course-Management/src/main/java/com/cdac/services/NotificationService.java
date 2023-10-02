package com.cdac.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cdac.models.Notification;
import com.cdac.repos.NotificationRepository;

@Service
public class NotificationService {

	@Autowired private NotificationRepository repo;
	
	public void save(Notification not) {
		not.setCreatedon(LocalDateTime.now());
		repo.save(not);
	}
	
	public List<Notification> listAll(){
		return repo.findAll(Sort.by(Direction.DESC, "id"));
	}
	
	public List<Notification> listtop10(){
		return repo.findTop10ByOrderByIdDesc();
	}
	
	public List<Notification> listFacultyNotifications(int id){
		return repo.findByFacultyIdOrderByIdDesc(id);
	}
	
	public Notification getById(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteNotification(int id) {
		repo.deleteById(id);
	}
}
