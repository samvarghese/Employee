package com.myspent.myspent.comtroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspent.myspent.VO.Register;
import com.myspent.myspent.dao.EmployeeDao;
import com.myspent.myspent.dao.UserDao;
import com.myspent.myspent.model.Departement;
import com.myspent.myspent.model.Employee;
import com.myspent.myspent.model.Roles;
import com.myspent.myspent.model.User;
import com.myspent.myspent.utility.MailServices;

@Controller
public class LoginController {

	@Autowired
	private UserDao dao;
	@Autowired
	private MailServices ms;
	
	@Autowired
	private EmployeeDao empDao;
	
	
	@RequestMapping("/")
	public String loginCheck() {
		System.out.println("hai");
		return "index";
	}

	@PostMapping("/saveDetails")
	public ModelAndView Check(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		System.out.println("username" + username);
		System.out.println("username" + password);
		ModelAndView md = new ModelAndView();

		User user = dao.findByUserNameAndPassword(username, password);
		if (user != null) {
			
			md.addObject("mssg", "Login Sucessfully");
		} else {
			md.addObject("mssg", "Invalid Creditial");
		}
		
		 List<Employee> empList=empDao.findAll();
//		 empList.forEach(x->{
//					 System.out.println("Employee_name "+x.getUsername()+"Email_"+x.getEmail()+""+"User_Name "+x.getUser().getUserName());
//		 });
		md.addObject("emp", empList);
		md.setViewName("EmpList");
		return md;
	}
	
	
	@PostMapping("/Register")
	public String Register(@ModelAttribute("Register") Register register) {
		System.out.println(register.getEmail());
		Employee emp=new Employee();
		emp.setUsername(register.getEmpName());
		emp.setDept(new Departement(register.getDeptId()));
		emp.setEmail(register.getEmail());
		
		User user=new User();
		user.setUserName(register.getUserName());
		user.setPassword(register.getPassword());
		user.setEmp(emp);
		
		emp.setUser(user);
		empDao.save(emp);
		
		ms.sendSimpleMessage("", "", "");
		
		//System.out.println("ddd"+register.getEmail());
		return "";
	}
	
	@PostMapping("/setRole")
	public String setRole(@RequestParam("name") String name,
			@RequestParam("userId") int userId,
			@RequestParam("userRole") int userRole
			){
		int flag=0;
		System.out.println("inside name");
		System.out.println("name"+name+"userId"+userId+"userRole"+userRole);
		User user=(User)dao.findByUserId(userId);
	
		List<Roles> role=new ArrayList<Roles>();
		role.addAll(user.getRoles());
		for(Roles x:user.getRoles()){
			if(x.getRole_id()==userId){
				 flag=1;
				
			}
		}
		
		if(flag==0){
			role.add(new Roles(userRole));
			user.setRoles(role);
			dao.save(user);
		}
		
	
		
		
		return "";
	}

}
