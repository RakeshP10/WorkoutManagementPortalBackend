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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bct.app.entity.User;
import com.bct.app.entity.UserTrackRecord;
import com.bct.app.payloads.UserResponse;
import com.bct.app.repository.UserRepository;
import com.bct.app.service.UserService;
import com.bct.app.service.UserTrackRecordService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserTrackRecordService userTrackRecordService;
	
//	@GetMapping("/list")
//	public List<User> getAllUser(){
//		return userService.getUsers();
//	}
	@GetMapping("/list")
	public UserResponse getAllUser(@RequestParam(value="pageNumber",defaultValue="0",required=false) Integer pageNumber,
								 @RequestParam(value="pageSize",defaultValue = "10",required = false) Integer pageSize){
		return userService.getUsers(pageNumber,pageSize);
	}
	
	@GetMapping("/get/{id}")
	public Optional<User> getUser(@PathVariable int id){
		return userService.getUser(id);
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
//	@PutMapping("/update")
//	public User updateUser(@RequestBody User user) {
//		return userService.updateUser(user);
//	}
//	
	@PutMapping("/update/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id) {
		return userService.updateUserById(user,id);
	}
	
//	@PutMapping("/updateName/{id}/{name}")
//	public User updateUser(@PathVariable int id, @PathVariable String name) {
//		return userService.updateUserName(id, name);
//	}
	
	@DeleteMapping("/delete")
	public void deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable int id) {
		userService.deleteUserByUserId(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAllUser() {
		userService.deleteAllUsers();
	}
	
	@GetMapping("/getByName/{firstName}")
	public User findUserByName(@PathVariable String firstName) {
		return userService.findUserByName(firstName);
	}
	

	@GetMapping("/getByEmail/{em}")
	public User findUserByEmail(@PathVariable String em) {
		return userService.findUserByEmail(em);
	}
	
	@GetMapping("/user/{userId}/trackRecord")
	public UserTrackRecord getAllRecordsOfCustomer(@PathVariable int userId){
		return userTrackRecordService.getAllRecordsOfUser(userId);
	}
	
	@PutMapping("/{id}/changePassword/{oldPassword}/{newPassword}")
	public String changePassword(@PathVariable int id, @PathVariable String oldPassword, @PathVariable String newPassword) {
		return userService.changePassword(oldPassword,newPassword, id);
	}
	
//	@GetMapping("/users")
//	public List<User> getCustomer(){
//		return userService.getUsers();
//	}
}	
