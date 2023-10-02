package com.cdac.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.models.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
	List<Feedback> findByStudentRollno(int rollno);
}
