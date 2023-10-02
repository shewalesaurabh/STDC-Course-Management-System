package com.cdac.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.models.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
	List<Assignment> findByCourseCid(int c);
	List<Assignment> findByFacultyId(int i);
}
