package com.bct.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bct.app.entity.User;
import com.bct.app.entity.UserTrackRecord;
import com.bct.app.repository.UserRepository;
import com.bct.app.repository.UserTrackRecordRepository;

@Service
public class UserTrackRecordService {
	
	@Autowired
	UserTrackRecordRepository repository;

	@Autowired
	UserRepository userRepository;
	public UserTrackRecord save(UserTrackRecord trackRrecord, int userId) {
		User user = userRepository.findById(userId).get();
		trackRrecord.setUser(user);
        return repository.save(trackRrecord);
	}
	
	
	public Iterable<UserTrackRecord> getAllRecord(){	
		return repository.findAll();
	}
	
	
	public UserTrackRecord findById(int id){
		return repository.findById(id).get();
	}
	
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	
	public UserTrackRecord update(UserTrackRecord record) {
		
		UserTrackRecord updateRecord=repository.save(record);
		return updateRecord;
	}

	public UserTrackRecord getAllRecordsOfUser(int userId) {
		List<UserTrackRecord> list = null;
		List<UserTrackRecord> listofUserTrackRecords = (List<UserTrackRecord>) repository.findAll();
		for (UserTrackRecord list_element : listofUserTrackRecords) {
			if(list_element.getUser().getUserId() == userId) {
				return list_element;
			}
		}
		return null;
	}


	public List<UserTrackRecord> searchByUserId(@PathVariable int user_id) {
		return repository.findByUserId(user_id);
	}
	
}
