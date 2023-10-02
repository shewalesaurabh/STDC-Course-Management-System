package com.cdac.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cdac.models.Feedback;
import com.cdac.models.Student;
import com.cdac.services.AssignmentService;
import com.cdac.services.FacultyService;
import com.cdac.services.FeedbackService;
import com.cdac.services.MaterialService;
import com.cdac.services.NotificationService;
import com.cdac.services.StudentService;

@Controller
public class StudentController {
	@Autowired private HttpSession session;
	@Autowired private MaterialService msrv;
	@Autowired private AssignmentService asrv;
	@Autowired private StudentService stdsrv;
	@Autowired private NotificationService nsrv;
	@Autowired private FacultyService fsrv;
	@Autowired private FeedbackService fbsrv;
	
	@GetMapping("/sdashboard")
	public String dashboard(Model model) {
		int id=Integer.parseInt(session.getAttribute("id").toString());
		Student std=stdsrv.findbyRollno(id);
		model.addAttribute("std", std);
		model.addAttribute("list", nsrv.listtop10());
		return "sdashboard";
	}
	
	@GetMapping("/feedback")
	public String feedback(Model model) {
		int id=Integer.parseInt(session.getAttribute("id").toString());
		model.addAttribute("faculties", fsrv.listFeedbackFaculty(id));
		model.addAttribute("list", fbsrv.studentFeedbacks(id));
		return "feedback";
	}
	
	@PostMapping("/feedback")
	public String feedbackSubmit(Feedback fb,RedirectAttributes ra) {
		fbsrv.save(fb);
		ra.addFlashAttribute("msg", "Feedback submitted");
		return "redirect:/feedback";
	}
	
	@GetMapping("/smaterial")
	public String material(Model model) {
		int id=(int)session.getAttribute("id");
		Student std=stdsrv.findbyRollno(id);
		model.addAttribute("list", msrv.listCourseMaterial(std.getCourse().getCid()));
		return "smaterial";
	}
	
	@GetMapping("/sassignments")
	public String assignments(Model model) {
		int id=(int)session.getAttribute("id");
		Student std=stdsrv.findbyRollno(id);
		model.addAttribute("list", asrv.listCourseMaterial(std.getCourse().getCid()));
		return "sassignments";
	}
	
}
