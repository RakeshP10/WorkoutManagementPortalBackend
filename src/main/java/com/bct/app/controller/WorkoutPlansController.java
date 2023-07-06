package com.bct.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bct.app.entity.Exercise;
import com.bct.app.entity.User;
import com.bct.app.entity.WorkoutPlans;
import com.bct.app.service.WorkoutPlansService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/workoutplan")
public class WorkoutPlansController {
	
	@Autowired
	WorkoutPlansService workout_plan_services;
	
	@PostMapping(path = "/register")
	public WorkoutPlans save(@RequestBody WorkoutPlans workout_plan_entity) {
		return workout_plan_services.save(workout_plan_entity);
	}
	
	@GetMapping("/get/{id}")
	public Optional<WorkoutPlans> getWorkoutPlans(@PathVariable int id){
		return workout_plan_services.getWorkoutPlans(id);
	}
	
	@PutMapping(path = "/update/{id}")
	public WorkoutPlans update(@RequestBody WorkoutPlans e, @PathVariable int id) {
		return workout_plan_services.update(e,id);
	}
	
	@GetMapping(path="/list")
	public Iterable<WorkoutPlans> getAllPlans()
	{
		return workout_plan_services.getAllPlans();
	}
	
	@GetMapping(path = "/getByName/{name}")
	public List<WorkoutPlans> getByPlanName(@PathVariable("name") String name) {
		return workout_plan_services.getByPlanName(name);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void delete(@PathVariable("id") int id)
	{
		workout_plan_services.delete(id);
	}
	
	@GetMapping(path="/getPlanByLevel/{level}")
    public List<WorkoutPlans> getPlanByLevel(@PathVariable("level") String level)
    {
        return workout_plan_services.getPlanByLevel(level);
    }
}
