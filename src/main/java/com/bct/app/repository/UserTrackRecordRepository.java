package com.bct.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bct.app.entity.UserTrackRecord;

@Repository
public interface UserTrackRecordRepository extends CrudRepository<UserTrackRecord, Integer>{

	@Query(value = "SELECT * FROM user_track_record WHERE user_id=?1", nativeQuery = true)
	List<UserTrackRecord> findByUserId(int userId);

}
