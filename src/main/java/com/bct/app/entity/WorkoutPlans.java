package com.bct.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="workout_plans")
public class WorkoutPlans {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planId;
	
	@Column(name="plan_name")
	private String planName;
	
	@Column(name="plan_level")
	private String planLevel;
	
	@Column(name="plan_description")
	private String planDescription;

	@JsonIgnore
	@OneToMany(mappedBy = "workoutPlan",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Exercise> exercises;
	
	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanLevel() {
		return planLevel;
	}

	public void setPlanLevel(String planLevel) {
		this.planLevel = planLevel;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public WorkoutPlans() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	@Override
	public String toString() {
		return "WorkoutPlans [planId=" + planId + ", planName=" + planName + ", planLevel=" + planLevel
				+ ", planDescription=" + planDescription + ", exercises=" + exercises + "]";
	}

	public WorkoutPlans(int planId, String planName, String planLevel, String planDescription,
			List<Exercise> exercises) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planLevel = planLevel;
		this.planDescription = planDescription;
		this.exercises = exercises;
	}
	
	
	
}
