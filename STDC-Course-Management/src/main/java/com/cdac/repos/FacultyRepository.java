package com.cdac.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cdac.models.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

	@Query(value="select * from faculty where id not in(select faculty_id from feedback where rollno=?1)", nativeQuery = true)
	List<Faculty> findFacultyForFeedback(int rollno);
}
