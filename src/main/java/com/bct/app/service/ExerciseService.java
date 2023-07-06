package com.bct.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bct.app.entity.Exercise;
import com.bct.app.entity.Exercise;
import com.bct.app.entity.WorkoutPlans;
import com.bct.app.repository.ExerciseRepository;
import com.bct.app.repository.WorkoutPlansRepository;

@Service
public class ExerciseService {
	
	@Autowired
	ExerciseRepository repository;
	
	@Autowired
	WorkoutPlansRepository workoutPlansRepository;
	
	@Autowired
	WorkoutPlansRepository plansRepository;
	
	public Iterable<Exercise> getAllExercises()
	{
		return repository.findAll();
	}
	
	public Exercise save(Exercise e, int planId) {
		WorkoutPlans plan = plansRepository.findById(planId).get();
		e.setWorkoutPlan(plan);
		return repository.save(e);
	}
	
	public Exercise getByName(String name)
	{
		Exercise ex=repository.findByName( name);
		return ex;
		
	}
	
	public Exercise update(Exercise e)
	{
		Exercise updatedExercise=repository.save(e);
		return updatedExercise;
	}
	
	public void delete(int exerciseId)
	{
		repository.deleteById(exerciseId);
	}

	public Optional<Exercise> getExercise(int id) {
		return repository.findById(id);
	}

	public Exercise updateExerciseName(int planId, int id, String name) {
		Optional<Exercise> exerciseOptional = repository.findById(id);
		Exercise exercise = exerciseOptional.get();
		exercise.setName(name);
		Exercise updatedExercise = repository.save(exercise);
		return updatedExercise;
	}

	public void deleteAllCustomers() {
		repository.deleteAll();
	}

	public List<Exercise> getAllExercisesByPlanId(int planId){
		return repository.findAllByPlanId(planId);
	}

	public Exercise updateById(Exercise e, int planId, int id) {
		Optional<Exercise> exerciseOptional = repository.findById(id);
		Exercise exercise = exerciseOptional.get();
		exercise.setName(e.getName());
		exercise.setReps(e.getReps());
		exercise.setEstimatedTime(e.getEstimatedTime());
		exercise.setSets(e.getSets());
		exercise.setDescription(e.getDescription());
		WorkoutPlans plan = plansRepository.findById(planId).get();
		exercise.setWorkoutPlan(plan);
		Exercise updatedExercise = repository.save(exercise);
		return updatedExercise;
	}
	
}

