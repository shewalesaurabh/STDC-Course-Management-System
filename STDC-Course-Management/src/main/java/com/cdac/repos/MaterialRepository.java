package com.cdac.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.models.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

	List<Material> findByCourseCid(int cid);
	List<Material> findByFacultyId(int lid);
}
