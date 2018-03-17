package com.myspent.myspent.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
	private List<Roles> roles;

	@OneToOne
	private Employee emp;

	public User(User user) {
		this.emp = user.getEmp();
		this.password = user.getPassword();
		this.roles = user.getRoles();
		this.userName = user.getUserName();
		this.userId = user.getUserId();
		// TODO Auto-generated constructor stub
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	// public User(String userName2, String password2, int i) {
	// // TODO Auto-generated constructor stub
	// this.userName=userName2;
	// this.password=password2;
	//
	// }
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
