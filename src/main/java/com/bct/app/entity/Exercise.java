package com.bct.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="exercise")
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="exercise_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="sets")
	private int sets;
	
	@Column(name="reps")
	private String reps;
	
	@Column(name="description")
	private String description;
	
	@Column(name="estimated_time")
	private String estimatedTime;

	@ManyToOne
	@JoinColumn(name="plan_id")
	private WorkoutPlans workoutPlan;
	
	public Exercise() {
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public String getReps() {
		return reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public WorkoutPlans getWorkoutPlan() {
		return workoutPlan;
	}

	public void setWorkoutPlan(WorkoutPlans workoutPlan) {
		this.workoutPlan = workoutPlan;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", sets=" + sets + ", reps=" + reps + ", description="
				+ description + ", estimatedTime=" + estimatedTime + ", workoutPlan=" + workoutPlan + "]";
	}

	public Exercise(int id, String name, int sets, String reps, String description, String estimatedTime,
			WorkoutPlans workoutPlan) {
		super();
		this.id = id;
		this.name = name;
		this.sets = sets;
		this.reps = reps;
		this.description = description;
		this.estimatedTime = estimatedTime;
		this.workoutPlan = workoutPlan;
	}

	
	
}
