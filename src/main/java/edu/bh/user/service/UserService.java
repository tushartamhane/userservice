package edu.bh.user.service;

import java.util.List;

import edu.bh.user.entity.SuperUser;
import edu.bh.user.entity.User;

public interface UserService {
	
	public List<User> getUsers();
	public User getUser(Long id);
	public User modifyUser(User user);
	public String addUser(User user);
	public String remove(Long id);
	
	
	
	
	
	public List<SuperUser> getUsersWithRole();
}
