package com.bct.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bct.app.entity.WorkoutPlans;

@Repository
public interface WorkoutPlansRepository extends CrudRepository<WorkoutPlans, Integer>{
	public List<WorkoutPlans> findByPlanName(String planName);

	public List<WorkoutPlans> findByPlanLevel(String level);
}
