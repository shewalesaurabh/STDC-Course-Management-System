package com.cdac.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.models.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
	List<Notification> findByFacultyIdOrderByIdDesc(int id);
	List<Notification> findTop10ByOrderByIdDesc();
}
