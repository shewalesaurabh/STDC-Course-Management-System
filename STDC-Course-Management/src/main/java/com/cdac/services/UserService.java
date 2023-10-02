package com.cdac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.PasswordResetDTO;
import com.cdac.models.User;
import com.cdac.repos.UserRepository;

@Service
public class UserService {

	@Autowired private UserRepository repo;
	
	public void createAdmin() {
		if(repo.count()==0) {
			repo.save(new User("admin","admin","Admin","Administrator"));
		}
	}
	
	public User findUser(String userid) {
		return repo.findById(userid).orElse(null);
	}
	
	public void AddUser(User user) {
		repo.save(user);
	}
	
	public void ChangePwd(PasswordResetDTO dto) {
		User u=repo.findById(dto.getUserid()).get();
		u.setPwd(dto.getPassword());
		repo.save(u);
	}
	
	public void updateUser(User user) {
		repo.save(user);
	}
	
	public User validate(String userid,String pwd,String role) {
		Optional<User> uinfo=repo.findById(userid);
		if(uinfo.isPresent() && uinfo.get().getPwd().equals(pwd) && uinfo.get().isActive() && uinfo.get().getRole().equals(role)) {
			return uinfo.get();
		}			
		return null;
	}
	
	public User verify(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<User> getAllUser(){
		return repo.findAll();
	}
}
