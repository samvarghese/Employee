package com.myspent.myspent.comtroller;

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

@Controller
public class LoginController {

	@Autowired
	private UserDao dao;
	
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
		md.setViewName("index");
		return md;
	}
	
	
	@PostMapping("/Register")
	public String Register(@ModelAttribute("Register") Register register) {
		System.out.println(register.getEmail());
		Employee emp=new Employee();
		emp.setUsername(register.getUserName());
		emp.setDept(new Departement(register.getDeptId()));
		emp.setEmail(register.getEmail());
		empDao.save(emp);
		
		System.out.println("ddd"+register.getEmail());
		return "";
	}

}
