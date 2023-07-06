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
import com.bct.app.service.ExerciseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/exercise")
public class ExerciseController {
	
	@Autowired
	ExerciseService service;
	
	@GetMapping(path="/list")
	public Iterable<Exercise> getAllExercises()
	{
		return service.getAllExercises();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Exercise> getExercise(@PathVariable int id){
		return service.getExercise(id);
	}
	
	@PostMapping(path = "/{planId}/register")
	public Exercise save(@RequestBody Exercise exercise, @PathVariable int planId) {
		return service.save(exercise,planId);
	}
	
	@PutMapping(path = "/update")
	public Exercise update(@RequestBody Exercise e) {
		Exercise updatedExercise=service.update(e);
		return updatedExercise;
	}
	
//	@PutMapping(path = "/update/{id}")
//	public Exercise update(@RequestBody Exercise e, @PathVariable int id) {
//		Exercise updatedExercise=service.updateById(e, id);
//		return updatedExercise;
//	}
	
	@PutMapping("/{planId}/update/{id}")
	public Exercise updateExerciseById(@RequestBody Exercise e, @PathVariable int planId, @PathVariable int id) {
		return service.updateById(e, planId, id);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void delete(@PathVariable("id") int id)
	{
		service.delete(id);
	}

	@DeleteMapping("/deleteAll")
	public void deleteAllCustomer() {
		service.deleteAllCustomers();
	}
	
	@GetMapping(path = "/getByName/{name}")
	public Exercise findByName(@PathVariable("name") String name) {
		return service.getByName(name);
	}
	
	@GetMapping(path = "/getAllExercise/{planId}")
	public List<Exercise> findAllExercisesByPlanId(@PathVariable("planId") int planId){
		return service.getAllExercisesByPlanId(planId);
	}
	
}
