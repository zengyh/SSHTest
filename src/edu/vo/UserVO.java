package edu.vo;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class UserVO implements java.io.Serializable {
	
	private static final long serialVersionUID = 7132790140796457462L;
	
	// Fields
	private Integer id;
	private String username;
	private String password;

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}