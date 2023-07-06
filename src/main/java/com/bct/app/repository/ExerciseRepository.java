package com.bct.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bct.app.entity.Exercise;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer>{

	public Exercise findByName(String name);
	
	@Query(value = "SELECT * FROM exercise WHERE plan_id=?1", nativeQuery = true)
	List<Exercise> findAllByPlanId(int planId);
}
