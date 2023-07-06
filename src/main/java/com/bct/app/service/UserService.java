package com.bct.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bct.app.config.AppConstants;
import com.bct.app.entity.Role;
import com.bct.app.entity.User;
import com.bct.app.payloads.UserResponse;
import com.bct.app.repository.RoleRepository;
import com.bct.app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User findOne(int id) {
		Iterable<User> list = userRepository.findAll();
		for (User user : list) {
			if(user.getUserId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User registerUser(User user) {
		// encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		// roles
		Role role = this.roleRepository.findById(AppConstants.NORMAL_USER).get();
		user.getRoles().add(role);
		User newUser = this.userRepository.save(user);
		return newUser;
	}
	
	public User updateUser(User user) {
		User updatedUser = userRepository.save(user); 
		return updatedUser;
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	public void deleteUserByUserId(int id) {
		userRepository.deleteById(id);
	}
	
	public void deleteAllUsers() {
		Iterable<User> allUsers = userRepository.findAll();
		allUsers.forEach(user->System.out.println(user));
		userRepository.deleteAll(allUsers);
	}
//	public List<User> getUsers() {
//
//		return (List<User>) userRepository.findAll();
//	}
	
	public UserResponse getUsers(Integer pageNumber,Integer pageSize) {
//		int pageSize=5;
//		int pageNumber=1;

		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<User> pageUser=userRepository.findAll(p);
		List<User> allUsers = pageUser.getContent();

		UserResponse userResponse = new UserResponse();
		userResponse.setContent(allUsers);
		userResponse.setPageNumber(pageUser.getNumber());
		userResponse.setPageSize(pageUser.getSize());
		userResponse.setTotalElements(pageUser.getTotalElements());
		userResponse.setTotalPages(pageUser.getTotalPages());
		userResponse.setLastPage(pageUser.isLast());
		
		return userResponse;
	}
	
	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
	}

	public User updateUserName(int id, String name) {
		Optional<User> userOptional = userRepository.findById(id);
		User user = userOptional.get();
		user.setUserName(name);
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	
	public User updateUserById(User user2, int id) {
		Optional<User> userOptional = userRepository.findById(id);
		User user = userOptional.get();
		user.setUserName(user2.getUserName());
		user.setEmail(user2.getEmail());
		user.setAge(user2.getAge());
		user.setContactNumber(user2.getContactNumber());
		user.setWeight(user2.getWeight());
		user.setGender(user2.getGender());
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	
	public User findUserByName(String firstName) {
		User users = userRepository.findByUserName(firstName);
		return users;
	}
	
	public User findUserByEmail(String em) {
		User users = userRepository.findByEmail(em);
		return users;
	}

	public String changePassword(String old, String newPwd, int id) {
		User user = userRepository.findById(id).get();
		if(this.bCryptPasswordEncoder.matches(old, user.getPassword()))
		{
			user.setPassword(this.bCryptPasswordEncoder.encode(newPwd));
			this.userRepository.save(user);
			return "Success";
		}
		else {
			return "Error";
		}
		
	}
}
