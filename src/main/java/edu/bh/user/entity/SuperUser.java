package edu.bh.user.entity;

public class SuperUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String role="Super User";
	
	private User user;
	
	public SuperUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public SuperUser(String role, User user) {
		super();
		this.role = role;
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
