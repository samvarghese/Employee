package com.myspent.myspent.VO;

public class Register {
	private String empName;
	private String email;
	private String  userName;
	private String password;
	private int deptId;
	
	
	public Register(String empName, String email, String userName,
			String password, int deptId) {
		super();
		this.empName = empName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.deptId = deptId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptName(int deptName) {
		this.deptId = deptName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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


