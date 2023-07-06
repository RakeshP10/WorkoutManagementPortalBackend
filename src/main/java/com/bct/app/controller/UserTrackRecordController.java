package com.bct.app.controller;

import java.util.List;

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

import com.bct.app.entity.UserTrackRecord;
import com.bct.app.service.UserTrackRecordService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/trackRecord")
public class UserTrackRecordController {
	
	@Autowired
	private UserTrackRecordService service;
	
	// for saving the new track record;
	@PostMapping("/{customerId}/register")
	public UserTrackRecord save(@RequestBody UserTrackRecord UserTrackRecord, @PathVariable int customerId) {
	    return service.save(UserTrackRecord, customerId);
	}
	
	@GetMapping("/list")
	public Iterable<UserTrackRecord > getalltrackrecord(){
		return  service.getAllRecord();
	}
	
	@GetMapping("/search/{track_id}")
	public UserTrackRecord searchByTrackRecordId(@PathVariable int track_id) {
		return  service.findById(track_id);
	}
	
	@PutMapping("/update/{customerId}/{track_id}")
	public UserTrackRecord update(@RequestBody UserTrackRecord UserTrackRecord, int customerId) {
		UserTrackRecord updateRecord=service.save(UserTrackRecord, customerId);
		return updateRecord;
	}
	
	@DeleteMapping("/delete/{track_id}")
	public String delete(@PathVariable("track_id") int track_id) {
		 service.delete(track_id);
		 return "Track Record Deleted";
	}
	
//	@PutMapping("/{customerId}/customerTrackRecord/{trackId}")
//	public UserTrackRecord submitRecordToUser(@PathVariable int customerId, @PathVariable int trackId) {
//		UserTrackRecord record = service.findById(trackId);
//		User customer = customerService.findOne(customerId);
//		customer.submitRecordToUser(record);
//		UserTrackRecord sUserTrackRecord = service.saveMethod(customer); 
//		return sUserTrackRecord
//	}

//	@GetMapping("/{customerId}/trackRecord")
//	public UserTrackRecord getAllRecordsOfUser(@PathVariable int customerId){
//		return service.getAllRecordsOfUser(customerId);
//	}
	
	@GetMapping("/{custId}/getAll")
	public List<UserTrackRecord> getAllTrackRecordsByUserId(@PathVariable("custId") int custId) {
		 return service.searchByUserId(custId);
	}
}
