package com.bct.app.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class UserTrackRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="track_id")
	private int trackId;
	
	@Column(name="workout_plan")
	private String workoutPlan;
	
	private float weight;
	
	@Column(name="number_of_exercise")
	private int noOfExercise;
	
	@Column(name="set_per_exercise")
	private int setPerExercise;
	
	@Column(name="repetition_per_set")
	private String repPerSet;
	
	private String comments;

//	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate submitDate;

	@PrePersist
	private void onCreate() {
		submitDate = LocalDate.now();
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getWorkoutPlan() {
		return workoutPlan;
	}

	public void setWorkoutPlan(String workoutPlan) {
		this.workoutPlan = workoutPlan;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getNoOfExercise() {
		return noOfExercise;
	}

	public void setNoOfExercise(int noOfExercise) {
		this.noOfExercise = noOfExercise;
	}

	public int getSetPerExercise() {
		return setPerExercise;
	}

	public void setSetPerExercise(int setPerExercise) {
		this.setPerExercise = setPerExercise;
	}

	public String getRepPerSet() {
		return repPerSet;
	}

	public void setRepPerSet(String repPerSet) {
		this.repPerSet = repPerSet;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "UserTrackRecord [trackId=" + trackId + ", workoutPlan=" + workoutPlan + ", weight=" + weight
				+ ", noOfExercise=" + noOfExercise + ", setPerExercise=" + setPerExercise + ", repPerSet=" + repPerSet
				+ ", comments=" + comments + ", user=" + user + ", submitDate=" + submitDate + "]";
	}



	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

	public UserTrackRecord(int trackId, String workoutPlan, float weight, int noOfExercise, int setPerExercise,
			String repPerSet, String comments, User user, LocalDate submitDate) {
		super();
		this.trackId = trackId;
		this.workoutPlan = workoutPlan;
		this.weight = weight;
		this.noOfExercise = noOfExercise;
		this.setPerExercise = setPerExercise;
		this.repPerSet = repPerSet;
		this.comments = comments;
		this.user = user;
		this.submitDate = submitDate;
	}

	public UserTrackRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
