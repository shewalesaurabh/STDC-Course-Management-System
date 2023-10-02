package com.cdac.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	List<Subject> findByCourseCid(int course);
}
