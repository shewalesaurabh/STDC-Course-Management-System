package com.cdac.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cdac.dto.LoginDTO;
import com.cdac.dto.PasswordResetDTO;
import com.cdac.dto.RegisterDTO;
import com.cdac.models.Faculty;
import com.cdac.models.Student;
import com.cdac.models.User;
import com.cdac.services.FacultyService;
import com.cdac.services.StudentService;
import com.cdac.services.UserService;

@Controller
public class HomeController {

	@Autowired private HttpSession session;
	@Autowired private UserService usrv;
	@Autowired private FacultyService isrv;
	@Autowired private StudentService ssrv;
	@GetMapping("/")
	public String homepage() {
		return "index";
	}
	
	@PostMapping("/")
	public String validate(LoginDTO dto,RedirectAttributes ra) {
		System.out.println(dto);
		User user=usrv.validate(dto.getUserid(), dto.getPwd(),dto.getRole());
		if(user!=null) {
			session.setAttribute("role", user.getRole());
			session.setAttribute("userid", user.getUserid());
			session.setAttribute("uname", user.getUname());
			session.setAttribute("id", user.getId());
			if(dto.getRole().equals("Admin")) {
				return "redirect:/dashboard";
			}else if(dto.getRole().equals("Student")) {
				return "redirect:/sdashboard";
			}else {
				return "redirect:/idashboard";
			}
		}else {
			ra.addFlashAttribute("error", "Invalid userid and password");
			return "redirect:/";
		}
	}
	
	@PostMapping("/register")
	public String registerUser(RegisterDTO dto, RedirectAttributes ra) {
		User user=new User(dto.getUserid(), dto.getPwd(), dto.getRole(), dto.getUname());
		user.setId(dto.getId());
		usrv.AddUser(user);
		ra.addFlashAttribute("msg", "User registered successfully");
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/verify")
	@ResponseBody
	public String verifyEmail(int id,String role) {
		if(role.equals("Faculty")) {
			Faculty ins=isrv.findById(id);
			return ins==null ? "Invalid":ins.getName();
		}else if(role.equals("Student")) {
			Student std=ssrv.findbyRollno(id);
			return std==null ? "Invalid" : std.getName();
		}
		return "Invalid";
	}
	
	@PostMapping("/changepwd")
	public String updatePassword(PasswordResetDTO dto,RedirectAttributes ra) {
		usrv.ChangePwd(dto);
		ra.addFlashAttribute("msg", "Password updated successfully");
		String role=session.getAttribute("role").toString();
		if(role.equals("Admin"))
			return "redirect:/dashboard";
		else if(role.equals("Student"))
			return "redirect:/sdashboard";
		else
			return "redirect:/idashboard";
	}
}
