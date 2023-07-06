package com.bct.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bct.app.entity.Exercise;
import com.bct.app.entity.User;
import com.bct.app.entity.WorkoutPlans;
import com.bct.app.repository.WorkoutPlansRepository;

@Service
public class WorkoutPlansService {
	
	@Autowired
	WorkoutPlansRepository planRepository;
	
	public WorkoutPlans save(WorkoutPlans e) {
		return planRepository.save(e);
	}
	
	public WorkoutPlans update(WorkoutPlans e, int id)
	{
		Optional<WorkoutPlans> planOptional = planRepository.findById(id);
		WorkoutPlans plan = planOptional.get();
		plan.setPlanName(e.getPlanName());
		plan.setPlanLevel(e.getPlanLevel());
		plan.setPlanDescription(e.getPlanDescription());
		WorkoutPlans updatedPlan = planRepository.save(plan);
		return updatedPlan;
	}
	
	public Iterable<WorkoutPlans> getAllPlans()
	{
		return planRepository.findAll();
	}
	
	public List<WorkoutPlans> getByPlanName(String name)
	{
		List<WorkoutPlans> workoutPlans=planRepository.findByPlanName(name);
		return workoutPlans;
	}
	
	public void delete(int id)
	{
		planRepository.deleteById(id);
	}

	public Optional<WorkoutPlans> getWorkoutPlans(int id) {
		return planRepository.findById(id);
	}

	public List<WorkoutPlans> getPlanByLevel(String level) {
		return planRepository.findByPlanLevel(level);
	}



}
